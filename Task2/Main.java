package Task2;

import Task2.Publications.PublicationTypes.*;
import Task2.Publications.Availability;

public class Main 
{
    
    public static void main(String[] args)
    {
        Book book = new Book(1, "The bean man", 200, "Penguin", true, "Donald Donaldson");
        book.setEdition("1st");
        book.setDescription("This is a funny book about a man who likes beans");
        book.setAvailability(Availability.BORROWED);
        System.out.println(book.getAllInfo());
    }
}
