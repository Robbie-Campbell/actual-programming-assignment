package Task2.Publications.PublicationTypes;

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
        if (this.topic == null)
            return "Not Set";
        else
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
    
}
