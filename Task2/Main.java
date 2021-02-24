package Task2;

import Task2.Publications.PublicationTypes.*;

import java.util.ArrayList;

import Task2.Publications.Availability;

// The main class
public class Main 
{

    // Run the main method
    public static void main(String[] args)
    {

        // Test the magazine class
        Magazine magazine = new Magazine(1, "Woman Speak", 30, "Womyn", false, 10);
        magazine.setEdition("1st");
        magazine.setDescription("This is a cool magazine");
        magazine.setAvailability(Availability.BORROWED);
        ArrayList<String> editors = new ArrayList<String>();
        editors.add("Tony Banana");
        editors.add("Harry Aids");
        magazine.setEditors(editors);
        System.out.println(magazine.getAllInfo());

        System.out.println("\n------------------------------------------\n");

        // Test the newspaper class
        Newspaper newspaper = new Newspaper(1, "The Moon", 30, "British Publish House", false, 3, "Tabloid");
        newspaper.setEdition("1st");
        newspaper.setDescription("This is a cool newspaper");
        newspaper.setAvailability(Availability.BORROWED);
        ArrayList<String> editors1 = new ArrayList<String>();
        editors1.add("Tony Banana");
        editors1.add("Harry Aids");
        newspaper.setEditors(editors1);
        ArrayList<String> columns = new ArrayList<String>();
        columns.add("Chicken Run: Is it really that good?");
        columns.add("Bean Tortillas: Going Forward");
        newspaper.setColumns(columns);
        System.out.println(newspaper.getAllInfo());

        System.out.println("\n------------------------------------------\n");

        // Test the map class
        Map map = new Map(1, "England", 2, "Penguin", false, "Germany");
        map.setEdition("3rd");
        map.setDescription("This is a cool map");
        map.setAvailability(Availability.AVAILABLE);
        System.out.println(map.getAllInfo());

        System.out.println("\n------------------------------------------\n");

        // Test the journal class
        Journal journal = new Journal(1, "Beep Boop Bop", 120, "Cisco", false, 5, "Computer Science");
        journal.setEdition("1st");
        journal.setDescription("This is a cool journal");
        journal.setAvailability(Availability.BORROWED);
        ArrayList<String> editors3 = new ArrayList<String>();
        editors3.add("Tony Banana");
        editors3.add("Harry Aids");
        journal.setEditors(editors3);
        System.out.println(journal.getAllInfo());

        System.out.println("\n------------------------------------------\n");

        // Test the book class
        Book book = new Book(1, "Scary House", 50, "Penguin", true, "Dick Campbell");
        book.setEdition("1st");
        book.setDescription("This is a cool book");
        book.setAvailability(Availability.BORROWED);
        book.setGenre("Horror");
        book.setRating("3 Stars");
        System.out.println(book.getAllInfo());
    }
}
