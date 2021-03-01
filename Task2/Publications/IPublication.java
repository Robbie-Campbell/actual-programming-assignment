package Task2.Publications;

// Allow date to be used as a data type
import java.util.Date;

// The interface for all publications
public interface IPublication {

    // Get the publication ID
    public int getID();
    
    // Get publication description
    public String getDescription();

    // Set publication description
    public void setDescription(String description);

    // Get publication title
    public String getTitle();

    // Get the current availability of the publication
    public Availability getAvailability();

    // Set the current availability of the publication
    public void setAvailability(Availability availability);

    // Get the publisher of the publication
    public String getPublisher();

    // Get the current edition of the publication 
    public String getEdition();

    // Get the current edition of the publication 
    public void setEdition(String edition);

    // Get if the publication is available online
    public boolean getOnlineAvailability();

    // Set a return date of the publication
    public void setReturnDate(String date);

    // Provide the of the publication
    public String getReturnDate();

    // Get the length of the publication
    public int getLength();

}
