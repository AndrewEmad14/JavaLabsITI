package Lab_day6.LibraryProject.View;

import Lab_day6.LibraryProject.Controller.Library;
import Lab_day6.LibraryProject.Model.*;
import Lab_day6.LibraryProject.Utilities.ItemNotFoundException;

public class Main {
    public static void main(String args[]) {

        System.out.println("Library Management System");
        Library library = new Library();
        LibraryItem book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, true);
        LibraryItem book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960, true);
        LibraryItem magazine1 = new Magazine("National Geographic", "Various", 2021, true);

        library.addItem(book1);
        library.addItem(book2);
        library.addItem(magazine1);
        try {
            LibraryItem item = library.getItem(5);
        } catch (ItemNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        library.display();
    }
}
