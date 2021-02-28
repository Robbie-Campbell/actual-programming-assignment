package Task2.Publications;

import java.util.ArrayList;

// The super class for periodical publications (magazines, newspapers and journals)
public abstract class Periodicals extends Publication
{

    // Initialise varaible pointers
    private int issue;
    private ArrayList<String> editors;

    // Constructor method
    public Periodicals(int id, String title, int length, String publisher, boolean onlineAvailability, int issue) 
    {
        super(id, title, length, publisher, onlineAvailability);

        this.issue = issue;
    }
    
    // Get the issue of the periodical
    public int getIssue()
    {
        return this.issue;
    }

    // Set the editors who worked on the periodical
    public void setEditors(ArrayList<String> editors)
    {
        this.editors = editors;
    }

    // Display all of the editors who worked on the periodical
    public String listEditors()
    {

        // If the list hasn't been created
        if (this.editors == null)
        {
            return "Not Set";
        }

        // Return the list of editors in a readable way
        else
        {

            // Append to this to create the return value
            StringBuilder editors = new StringBuilder();

            // To record the index
            int index = 0;

            // Loop through each editor
            for (String editor: this.editors)
            {
                if(this.editors.size() - 2 == index)
                {
                    editors.append(editor + " and ");
                }
                else if (this.editors.size() - 1 > index)
                {
                    editors.append(editor + ", ");
                }
                
                else
                {
                    editors.append(editor);
                }
                ++index;
            }

            // Return the string values of the user
            return editors.toString();
        }
    }
}
