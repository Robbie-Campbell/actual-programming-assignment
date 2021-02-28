package Task2.Publications.PublicationTypes;

import java.sql.SQLException;
import java.sql.Statement;

import Task2.Publications.Periodicals;

// The Journal class
public class Journal extends Periodicals
{

    // Initialise variable
    private String academicArea;

    // Constructor method
    public Journal(int id, String title, int length, String publisher, boolean onlineAvailability, int issue, String academicArea) 
    {
        super(id, title, length, publisher, onlineAvailability, issue);
        
        this.academicArea = academicArea;
    }

    // Get the academic field of the journal
    public String getAcademicArea()
    {
        return this.academicArea;
    }

    // Create the Journal table
    public void createJournalTable() throws SQLException
    {
        String createTableString =
            "CREATE TABLE journal" + 
            "(issue INT NULL, " + 
            "academic_area VARCHAR(20) NULL " + 
            ") INHERITS (publication)";

        try (Statement statement = this.connect().createStatement())
        {
            statement.executeQuery(createTableString);
        }
    }

    // Override the abstract getAllInfo method for the Journal
    @Override
    public String getAllInfo() 
    {
        return String.format("Journal ID: %d\nTitle: %s\nPublisher: %s\nEdition: %s\nAvailability: %s\nAccessible Online: %b\nDescription: %s\nReturn Date: %s\nIssue: %s\nEditors: %s\nAcademic Field: %s"
                            , this.getID(), this.getTitle(), this.getPublisher(), this.getEdition(), this.getAvailability(), this.getOnlineAvailability()
                            , this.getDescription(), this.getReturnDate(), this.getIssue(), this.listEditors(), this.getAcademicArea());
    }
    
}
