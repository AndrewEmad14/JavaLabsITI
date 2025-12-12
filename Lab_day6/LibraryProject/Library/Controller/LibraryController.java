package Lab_day6.LibraryProject.Library.Controller;

import java.util.ArrayList;

import Lab_day6.LibraryProject.Library.Model.LibraryItem;
import Lab_day6.LibraryProject.Utilities.ItemNotFoundException;

public class LibraryController<T extends LibraryItem> {
    private ArrayList<T> libraryItemsList = new ArrayList<>();

    // create
    public void addItem(T item) {
        libraryItemsList.add(item);
    }

    // retrieve
    public T getItem(int id) throws ItemNotFoundException {

        for (T item : libraryItemsList) {
            if (item.getID() == id) {
                return item;

            }
        }
        throw new ItemNotFoundException();
    }

    // display
    public void display() {
        System.out.println("Library Items:");
        for (T item : libraryItemsList) {
            System.out.println(item);
        }
    }

    // find
    public boolean findItem(int id) {
        for (T item : libraryItemsList) {
            if (item.getID() == id) {
                return true;
            }
        }
        return false;
    }

    // remove
    public void removeItem(int id) {
        libraryItemsList.removeIf(item -> item.getID() == id);
    }

    // update
    public void updateItem(int id, T newItem) throws ItemNotFoundException {
        for (int i = 0; i < libraryItemsList.size(); i++) {
            if (libraryItemsList.get(i).getID() == id) {
                libraryItemsList.set(i, newItem);
                return;
            }
        }
        throw new ItemNotFoundException();
    }

    public ArrayList<T> getLibraryItemsList() {
        return libraryItemsList;
    }

}
