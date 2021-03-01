package Task2.Publications.PublicationTypes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import Task2.Publications.Periodicals;

// The Magazine class
public class Magazine extends Periodicals
{

    // Initialise variable
    private String topic;

    // Constructor method
    public Magazine(int id, String title, int length, String publisher, boolean onlineAvailability, int issue) 
    {
        super(id, title, length, publisher, onlineAvailability, issue);
    }

    // Return the topic of the magazine or an unset message
    public String getTopic()
    {
        return this.topic;
    }

    // Set the topic of the magazine
    public void setTopic(String topic)
    {
        this.topic = topic;
    }

    // Override the abstract getAllInfo method for the Magazine
    @Override
    public String getAllInfo() 
    {
        return String.format("Magazine ID: %d\nTitle: %s\nPublisher: %s\nEdition: %s\nAvailability: %s\nAccessible Online: %b\nDescription: %s\nReturn Date: %s\nIssue: %s\nEditors: %s\nTopic: %s"
                            , this.getID(), this.getTitle(), this.getPublisher(), this.getEdition(), this.getAvailability(), this.getOnlineAvailability()
                            , this.getDescription(), this.getReturnDate(), this.getIssue(), this.listEditors(), this.getTopic());
    }
    
    // DATABASE FUNCTIONALITY
    
    // Create the magazine table
    public void createMagazineTable() throws SQLException
    {
        String createTableString =
            "CREATE TABLE IF NOT EXISTS magazine" + 
            "(topic VARCHAR(20) NULL " + 
            ") INHERITS (publication)";

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
        "INSERT INTO magazine (" + this.baseInsert() + " topic)" + 
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
            statement.setString(9, this.getTopic());

            // Insert into database
            statement.executeUpdate();
        }
    }
}
