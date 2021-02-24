package Task2.Publications.PublicationTypes;

import java.util.ArrayList;

import Task2.Publications.Publication;

// The Map class
public class Map extends Publication
{

    // Initialise variable
    private String location;

    // Constructor method
    public Map(int id, String title, int length, String publisher, boolean onlineAvailability, String location) 
    {
        super(id, title, length, publisher, onlineAvailability);
        
        this.location = location;
    }

    // Get the location of the map
    public String getLocation()
    {
        return this.location;
    }

    // Override the abstract getAllInfo method for the Map
    @Override
    public String getAllInfo() {
        return String.format("Map ID: %d\nTitle: %s\nPublisher: %s\nEdition: %s\nAvailability: %s\nAccessible Online: %b\nDescription: %s\nReturn Date: %s\nLocation: %s"
                            , this.getID(), this.getTitle(), this.getPublisher(), this.getEdition(), this.getAvailability(), this.getOnlineAvailability()
                            , this.getDescription(), this.getReturnDate(), this.getLocation());
    }
    
}
