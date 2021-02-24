package Task2.Publications.PublicationTypes;

import java.util.ArrayList;

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

        // If the list hasn't been created
        if (this.columns == null)
        {
            return "Not Set";
        }

        // Return the list of columns in a readable way
        else
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
    }

    // Override the abstract getAllInfo method for the Newspaper
    @Override
    public String getAllInfo() {
        return String.format("Newspaper ID: %d\nTitle: %s\nPublisher: %s\nEdition: %s\nAvailability: %s\nAccessible Online: %b\nDescription: %s\nReturn Date: %s\nIssue: %s\nEditors: %s\nFormat: %s\nColumns: %s"
                            , this.getID(), this.getTitle(), this.getPublisher(), this.getEdition(), this.getAvailability(), this.getOnlineAvailability()
                            , this.getDescription(), this.getReturnDate(), this.getIssue(), this.listEditors(), this.getNewspaperFormat(), this.listColumns());
    }
    
}
