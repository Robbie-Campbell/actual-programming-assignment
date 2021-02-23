package Task2.Publications;

import java.util.ArrayList;

public abstract class Periodicals extends Publication
{

    private int issue;
    private ArrayList<String> editors;

    public Periodicals(int id, String title, int length, String publisher, boolean onlineAvailability, int issue) {
        super(id, title, length, publisher, onlineAvailability);

        this.issue = issue;
    }
    
    public int getIssue()
    {
        return this.issue;
    }

    public void setEditors(ArrayList<String> editors)
    {
        this.editors = editors;
    }

    public String listEditors()
    {
        if (this.editors == null)
        {
            return "Not Set";
        }

        else
        {
            StringBuilder editors = new StringBuilder();
            int index = 0;
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
            return editors.toString();
        }
    }
}
