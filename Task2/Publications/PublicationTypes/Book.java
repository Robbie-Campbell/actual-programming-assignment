package Task2.Publications.PublicationTypes;

import Task2.Publications.*;

public class Book extends Publication{

    String rating, author, genre;

    public Book(int id, String title, int length, String publisher, boolean onlineAvailability, String author) {
        super(id, title, length, publisher, onlineAvailability);
        
        this.author = author;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getGenre()
    {
        if (this.genre == null)
            return "Not Set";
        else
            return this.genre;
    }

    public String getRating()
    {
        if (this.rating == null)
            return "Not Set";
        else
            return this.rating;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String getAllInfo() 
    {
        return String.format("Book ID: %d\nTitle: %s\nPublisher: %s\nEdition: %s\nAvailability: %s\nAccessible Online: %b\nDescription: %s\nReturn Date: %s\nAuthor: %s\nRating: %s\nGenre: %s"
                            , this.getID(), this.getTitle(), this.getPublisher(), this.getEdition(), this.getAvailability(), this.getOnlineAvailability()
                            , this.getDescription(), this.getReturnDate(), this.getAuthor(), this.getRating(), this.getGenre());
    }
    
}
