package Task2.Publications.PublicationTypes;

import java.util.ArrayList;

import Task2.Publications.Periodicals;

public class Newspaper extends Periodicals
{

    private String newspaperFormat;
    private ArrayList<String> columns;

    public Newspaper(int id, String title, int length, String publisher, boolean onlineAvailability, int issue, String format)
    {
        super(id, title, length, publisher, onlineAvailability, issue);

        this.newspaperFormat = format;
    }

    public String getNewspaperFormat()
    {
        return this.newspaperFormat;
    }

    public void setColumns(ArrayList<String> columns)
    {
        this.columns = columns;
    }

    public String listColumns()
    {
        if (this.columns == null)
        {
            return "Not Set";
        }

        else
        {
            StringBuilder columns = new StringBuilder();
            int index = 0;
            for (String editor: this.columns)
            {
                if(this.columns.size() - 2 == index)
                {
                    columns.append(editor + " and ");
                }
                else if (this.columns.size() - 1 > index)
                {
                    columns.append(editor + ", ");
                }
                
                else
                {
                    columns.append(editor);
                }
                ++index;
            }
            return columns.toString();
        }
    }

    @Override
    public String getAllInfo() {
        return String.format("Newspaper ID: %d\nTitle: %s\nPublisher: %s\nEdition: %s\nAvailability: %s\nAccessible Online: %b\nDescription: %s\nReturn Date: %s\nIssue: %s\nEditors: %s\nFormat: %s\nColumns: %s"
                            , this.getID(), this.getTitle(), this.getPublisher(), this.getEdition(), this.getAvailability(), this.getOnlineAvailability()
                            , this.getDescription(), this.getReturnDate(), this.getIssue(), this.listEditors(), this.getNewspaperFormat(), this.listColumns());
    }
    
}
