package Task2.Publications.PublicationTypes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;

import Task2.Publications.Availability;
import Task2.Publications.Periodicals;

// The Newspaper class
public class Newspaper extends Periodicals
{

    // Initialise Variables
    private String newspaperFormat;
    private ArrayList<String> columns;

    // Constructor method
    public Newspaper(int id, String title, int length, String publisher, boolean onlineAvailability, int issue, String format)
    {
        super(id, title, length, publisher, onlineAvailability, issue);

        this.newspaperFormat = format;
    }

    // Get the newspaper format
    public String getNewspaperFormat()
    {
        return this.newspaperFormat;
    }

    // Set the columns / articles of the newspaper
    public void setColumns(ArrayList<String> columns)
    {
        this.columns = columns;
    }

    // Display all of the editors who worked on the periodical
    public String listColumns()
    {

        // Append to this to create the return value
        StringBuilder columns = new StringBuilder();

        // To record the index
        int index = 0;

        // Loop through each column
        for (String column: this.columns)
        {
            if(this.columns.size() - 2 == index)
            {
                columns.append(column + " and ");
            }
            else if (this.columns.size() - 1 > index)
            {
                columns.append(column + ", ");
            }
            
            else
            {
                columns.append(column);
            }
            ++index;
        }
        return columns.toString();
    }

    // Override the abstract getAllInfo method for the Newspaper
    @Override
    public String getAllInfo() {
        return String.format("Newspaper ID: %d\nTitle: %s\nPublisher: %s\nEdition: %s\nAvailability: %s\nAccessible Online: %b\nDescription: %s\nReturn Date: %s\nIssue: %s\nEditors: %s\nFormat: %s\nColumns: %s"
                            , this.getID(), this.getTitle(), this.getPublisher(), this.getEdition(), this.getAvailability(), this.getOnlineAvailability()
                            , this.getDescription(), this.getReturnDate(), this.getIssue(), this.listEditors(), this.getNewspaperFormat(), this.listColumns());
    }

    // DATABASE FUNCTIONALITY
    
    // Create the newspaper table
    public void createNewspaperTable() throws SQLException
    {

        // Create the unique columns for the newspaper table
        String createTableString =
            "CREATE TABLE IF NOT EXISTS newspaper" + 
            "(newspaper_format VARCHAR(20) NULL " + 
            ") INHERITS (periodical)";

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
        "INSERT INTO newspaper (" + this.baseInsert() + " issue, newspaper_format)" + 
        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            statement.setInt(9, this.getIssue());
            statement.setString(10, this.getNewspaperFormat());

            // Insert into database
            statement.executeUpdate();
        }
    }

    public String getDBinfo(int id) throws SQLException
    {
        String query = "SELECT title FROM newspaper WHERE publication_id = " + id;

        try(Statement statement = this.connect().createStatement())
        {
            ResultSet returnVal = statement.executeQuery(query);
            if (returnVal.next())
            {
                return returnVal.getString(2).toString();
            }
            else
            {
                return null;
            }
        }
    }

    public void updateDBInfo(String colName, String newVal) throws SQLException
    {
        String update = "UPDATE newspaper SET " + colName + " = ? WHERE publication_id = ?";

        try(PreparedStatement statement = this.connect().prepareStatement(update))
        {
            statement.setString(1, newVal);
            statement.setInt(2, this.getID());
            statement.executeUpdate();
        }
    }

}
