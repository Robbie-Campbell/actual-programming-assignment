package Task2.Publications;

// Allow date to be used as a data type
import java.util.Date;
import java.util.Calendar;

// Postgres Database connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// The superclass for all publications
public abstract class Publication implements IPublication {

    // Initialise all of the variables
    private String publisher, edition, description, title, serverAddress, username, password;
    private int length, publicationID;
    private Availability availability = Availability.AVAILABLE;
    private boolean onlineAvailability;
    private Date returnDate;

    // Constructor Method
    public Publication(int id, String title, int length, String publisher, boolean onlineAvailability)
    {
        this.title = title;
        this.publicationID = id;
        this.length = length;
        this.publisher = publisher;
        this.onlineAvailability = onlineAvailability;
        this.serverAddress = "jdbc:postgresql://localhost/library";
        this.username = secrets.username;
        this.password = secrets.password;
    }

    // Return the ID of the publication
    @Override
    public int getID() {
        return this.publicationID;
    }
    
    // Get the title of the publication
    @Override
    public String getTitle() {
        return this.title;
    }

    // Return the description of the publication or an unset message
    @Override
    public String getDescription() {
        if (this.description == null)
            return "Not Set";
        else
            return this.description;
    }

    // Set the description of the publication
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    // Get the availability of the publication
    @Override
    public Availability getAvailability() {
        return this.availability;
    }

    // Set availability of a book, if it is changed to borrowed, set return date to 2 weeks from now, else set return date to null
    @Override
    public void setAvailability(Availability availability) {
        this.availability = availability;
        if (this.availability == Availability.BORROWED)
        {
            int noOfDays = 14;
            Calendar calendar = Calendar.getInstance();     
            calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
            Date date = calendar.getTime();
            setReturnDate(date);
        }
        else
        {
            this.returnDate = null;
        }
    }

    // Get the publications publisher
    @Override
    public String getPublisher() {
        return this.publisher;
    }

    // Get the edition of the book or return not set
    @Override
    public String getEdition() {
        if (this.edition == null)
            return "Not Set";
        else
            return this.edition;
    }

    // Set the edition of the book
    @Override
    public void setEdition(String edition) {
        this.edition = edition;
    }

    // Return if the book is available online
    @Override
    public boolean getOnlineAvailability() {
        return this.onlineAvailability;
    }

    // Set the return date of the book (called in the setAvailability method)
    @Override
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    // Get the current return date or return not set
    @Override
    public String getReturnDate() {
        if (this.returnDate == null)
            return "Not Set";
        else
            return String.valueOf(returnDate);
    }

    // Get the length of the publication
    @Override
    public int getLength() {
        return this.length;
    }


    // Method to connect to a database
    public Connection connect()
    {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.serverAddress, this.username, this.password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

        // Create the super table for the 
        public void createDBTable() throws SQLException
        {
    
            // Create table script
            String createTableString = 
                "CREATE TABLE publication " + 
                "(publication_id INT NOT NULL, " +
                "title VARCHAR(30) NOT NULL, " + 
                "publisher VARCHAR(30) NOT NULL, " + 
                "edition VARCHAR(10) NULL, " + 
                "availability VARCHAR(15) NOT NULL, " + 
                "online_availability BOOLEAN NOT NULL, " + 
                "description TEXT NULL, " + 
                "return_date TIMESTAMP NULL, " + 
                "PRIMARY KEY (publication_id))";
    
            try (Statement statement = this.connect().createStatement())
            {
                statement.executeQuery(createTableString);
            }
        }


    // Define a method for each class to reveal all of their information
    public abstract String getAllInfo();

    
}
