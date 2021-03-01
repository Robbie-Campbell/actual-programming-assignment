package Task2.Publications;

// Allow date to be used as a data type
import java.util.Date;
import java.util.Calendar;

// Postgres Database connection
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

// The superclass for all publications
public abstract class Publication implements IPublication {

    // Initialise all of the variables
    private String publisher, edition, description, title, serverAddress, username, password, returnDate;
    private int length, publicationID;
    private Availability availability = Availability.AVAILABLE;
    private boolean onlineAvailability;

    // Constructor Method
    public Publication(int id, String title, int length, String publisher, boolean onlineAvailability)
    {
        this.title = title;
        this.publicationID = id;
        this.length = length;
        this.publisher = publisher;
        this.onlineAvailability = onlineAvailability;
        this.returnDate = null;
        this.serverAddress = "jdbc:postgresql://localhost/library?zeroDateTimeBehavior=convertToNull";
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
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String text = formatter.format(date);
            setReturnDate(text);
        }
        else
        {
            this.returnDate = null;
        }
    }

    // Get the publications publisher
    @Override
    public String getPublisher() 
    {
        return this.publisher;
    }

    // Get the edition of the book or return not set
    @Override
    public String getEdition() 
    {
        return this.edition;
    }

    // Set the edition of the book
    @Override
    public void setEdition(String edition) 
    {
        this.edition = edition;
    }

    // Return if the book is available online
    @Override
    public boolean getOnlineAvailability() 
    {
        return this.onlineAvailability;
    }

    // Set the return date of the book (called in the setAvailability method)
    @Override
    public void setReturnDate(String date) 
    {
        System.out.println(date);
        this.returnDate = date;
    }

    // Get the current return date or return not set
    @Override
    public String getReturnDate() 
    {

        return this.returnDate;
    }

    // Get the length of the publication
    @Override
    public int getLength() 
    {
        return this.length;
    }

    // ABSTRACT METHODS

    // Define a method for each class to reveal all of their information
    public abstract String getAllInfo();

    // Define a method for inserting data into the database
    public abstract void insertNewRow() throws SQLException;

    // DATABASE FUNCTIONALITY
    
    // Method to connect to a database
    public Connection connect()
    {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.serverAddress, this.username, this.password);
            System.out.println("Success");
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
            "CREATE TABLE IF NOT EXISTS publication" + 
            "(publication_id SERIAL, " +
            "title VARCHAR(30) NOT NULL, " + 
            "publisher VARCHAR(30) NOT NULL, " + 
            "length INT NOT NULL, " + 
            "edition VARCHAR(10) NULL, " + 
            "availability VARCHAR(15) NOT NULL, " + 
            "online_availability BOOLEAN NOT NULL, " + 
            "description TEXT NULL, " + 
            "return_date TIMESTAMP NULL, " + 
            "PRIMARY KEY (publication_id))";

        try (Statement statement = this.connect().createStatement())
        {
            statement.execute(createTableString);
        }
    }

    // Create the base prepared statement insert String
    public String baseInsert()
    {
        String script = "title, publisher, length, edition, availability, online_availability, description, return_date,";
        return script;
    }
}
