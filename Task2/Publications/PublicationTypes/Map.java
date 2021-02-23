package Task2.Publications.PublicationTypes;

import java.util.ArrayList;

import Task2.Publications.Publication;

public class Map extends Publication
{

    private String location;

    public Map(int id, String title, int length, String publisher, boolean onlineAvailability, String location) {
        super(id, title, length, publisher, onlineAvailability);
        
        this.location = location;
    }

    public String getLocation()
    {
        return this.location;
    }

    @Override
    public String getAllInfo() {
        return String.format("Map ID: %d\nTitle: %s\nPublisher: %s\nEdition: %s\nAvailability: %s\nAccessible Online: %b\nDescription: %s\nReturn Date: %s\nLocation: %s"
                            , this.getID(), this.getTitle(), this.getPublisher(), this.getEdition(), this.getAvailability(), this.getOnlineAvailability()
                            , this.getDescription(), this.getReturnDate(), this.getLocation());
    }
    
}
