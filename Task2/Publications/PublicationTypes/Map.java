package Task2.Publications.PublicationTypes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import Task2.Publications.Publication;

// The Map class
public class Map extends Publication
{

    // Initialise variable
    private String location;

    // Constructor method
    public Map(int id, String title, int length, String publisher, boolean onlineAvailability, String location) 
    {
        super(id, title, length, publisher, onlineAvailability);
        
        this.location = location;
    }

    // Get the location of the map
    public String getLocation()
    {
        return this.location;
    }

    // Override the abstract getAllInfo method for the Map
    @Override
    public String getAllInfo() {
        return String.format("Map ID: %d\nTitle: %s\nPublisher: %s\nEdition: %s\nAvailability: %s\nAccessible Online: %b\nDescription: %s\nReturn Date: %s\nLocation: %s"
                            , this.getID(), this.getTitle(), this.getPublisher(), this.getEdition(), this.getAvailability(), this.getOnlineAvailability()
                            , this.getDescription(), this.getReturnDate(), this.getLocation());
    }

    // DATABASE FUNCTIONALITY
    
    // Create the map table
    public void createMapTable() throws SQLException
    {
        String createTableString =
            "CREATE TABLE IF NOT EXISTS map" + 
            "(location VARCHAR(40) NULL) INHERITS (publication)";

        try (Statement statement = this.connect().createStatement())
        {
            statement.execute(createTableString);
        }
    }

    // Insert a new row in the database
    @Override
    public void insertNewRow() throws SQLException
    {

        // Create the string for the prepared statement
        String insertStatementString = 
        "INSERT INTO map (" + this.baseInsert() + " location)" + 
        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Insert all of the parameters into the prepared statement
        try (PreparedStatement statement = this.connect().prepareStatement(insertStatementString))
        {
            statement.setString(1, this.getTitle());
            statement.setString(2, this.getPublisher());
            statement.setInt(3, this.getLength());
            statement.setString(4, this.getEdition());
            statement.setString(5, this.getAvailability().toString());
            statement.setBoolean(6, this.getOnlineAvailability());
            statement.setString(7, this.getDescription());

            // Convert null value to one which can be read by postgres
            if (this.getReturnDate() == null)
            {
                statement.setNull(8, Types.TIMESTAMP);
            }
            else
            {
                statement.setTimestamp(8, Timestamp.valueOf(this.getReturnDate()));
            }
            statement.setString(9, this.getLocation());

            // Insert into database
            statement.executeUpdate();
        }
    }
}
