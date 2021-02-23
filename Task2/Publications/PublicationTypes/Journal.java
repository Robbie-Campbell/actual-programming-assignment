package Task2.Publications.PublicationTypes;

import Task2.Publications.Periodicals;

public class Journal extends Periodicals{

    private String academicArea;

    public Journal(int id, String title, int length, String publisher, boolean onlineAvailability, int issue, String academicArea) {
        super(id, title, length, publisher, onlineAvailability, issue);
        
        this.academicArea = academicArea;
    }

    public String getAcademicArea()
    {
        return this.academicArea;
    }

    @Override
    public String getAllInfo() {
        return String.format("Journal ID: %d\nTitle: %s\nPublisher: %s\nEdition: %s\nAvailability: %s\nAccessible Online: %b\nDescription: %s\nReturn Date: %s\nIssue: %s\nEditors: %s\nAcademic Field: %s"
                            , this.getID(), this.getTitle(), this.getPublisher(), this.getEdition(), this.getAvailability(), this.getOnlineAvailability()
                            , this.getDescription(), this.getReturnDate(), this.getIssue(), this.listEditors(), this.getAcademicArea());
    }
    
}
