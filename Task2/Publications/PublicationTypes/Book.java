package Task2.Publications.PublicationTypes;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import Task2.Publications.*;

// The book class
public class Book extends Publication
{

    // Initialise variables
    String rating, author, genre;

    // Constructor method
    public Book(int id, String title, int length, String publisher, boolean onlineAvailability, String author) 
    {
        super(id, title, length, publisher, onlineAvailability);
        
        this.author = author;
    }

    // Get the author of the book
    public String getAuthor()
    {
        return this.author;
    }

    // Return the genre of the book or an unset message
    public String getGenre()
    {
        return this.genre;
    }

    // Return the rating of the book or an unset message
    public String getRating()
    {
        return this.rating;
    }

    // Set the genre of the book
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Set the rating of the book
    public void setRating(String rating) {
        this.rating = rating;
    }

    // Override the abstract getAllInfo method for the Book
    @Override
    public String getAllInfo() 
    {
        return String.format("Book ID: %d\nTitle: %s\nPublisher: %s\nEdition: %s\nAvailability: %s\nAccessible Online: %b\nDescription: %s\nReturn Date: %s\nAuthor: %s\nRating: %s\nGenre: %s"
                            , this.getID(), this.getTitle(), this.getPublisher(), this.getEdition(), this.getAvailability(), this.getOnlineAvailability()
                            , this.getDescription(), this.getReturnDate(), this.getAuthor(), this.getRating(), this.getGenre());
    }

    // DATABASE FUNCTIONALITY

    // Create the Journal table
    public void createBookTable() throws SQLException
    {
        String createTableString =
            "CREATE TABLE IF NOT EXISTS book" + 
            "(author VARCHAR(20) NULL, " + 
            "genre VARCHAR(20) NULL, " + 
            "rating VARCHAR(20) NULL " + 
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
        "INSERT INTO book (" + this.baseInsert() + " author, genre, rating)" + 
        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

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
            statement.setString(9, this.getAuthor());
            statement.setString(10, this.getGenre());
            statement.setString(11, this.getRating());

            // Insert into database
            statement.executeUpdate();
        }
    }
    
}
