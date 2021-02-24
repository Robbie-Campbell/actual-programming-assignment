package Task2.Publications.PublicationTypes;

import Task2.Publications.*;

// The book class
public class Book extends Publication
{

    // Initialise variables
    String rating, author, genre;

    // Constructor method
    public Book(int id, String title, int length, String publisher, boolean onlineAvailability, String author) 
    {
        super(id, title, length, publisher, onlineAvailability);
        
        this.author = author;
    }

    // Get the author of the book
    public String getAuthor()
    {
        return this.author;
    }

    // Return the genre of the book or an unset message
    public String getGenre()
    {
        if (this.genre == null)
            return "Not Set";
        else
            return this.genre;
    }

    // Return the rating of the book or an unset message
    public String getRating()
    {
        if (this.rating == null)
            return "Not Set";
        else
            return this.rating;
    }

    // Set the genre of the book
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Set the rating of the book
    public void setRating(String rating) {
        this.rating = rating;
    }

    // Override the abstract getAllInfo method for the Book
    @Override
    public String getAllInfo() 
    {
        return String.format("Book ID: %d\nTitle: %s\nPublisher: %s\nEdition: %s\nAvailability: %s\nAccessible Online: %b\nDescription: %s\nReturn Date: %s\nAuthor: %s\nRating: %s\nGenre: %s"
                            , this.getID(), this.getTitle(), this.getPublisher(), this.getEdition(), this.getAvailability(), this.getOnlineAvailability()
                            , this.getDescription(), this.getReturnDate(), this.getAuthor(), this.getRating(), this.getGenre());
    }
    
}
