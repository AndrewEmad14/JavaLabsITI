package Lab_day6.LibraryProject.Library.Controller;

import java.util.ArrayList;
import java.util.stream.IntStream;

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
        return libraryItemsList.stream()
                .filter(item -> item.getID() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException());
    }

    // display
    public void displayItemList() {
        if (libraryItemsList.isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        libraryItemsList.forEach((item) -> System.out.println(item));
    }

    public void displayAvailableItems() {
        if (libraryItemsList.isEmpty()) {
            System.out.println("No items found.");
            return;
        }
        Boolean hasAvailableItems = libraryItemsList.stream()
                .anyMatch(item -> item.getStockQuantity() > 0);
        if (!hasAvailableItems) {
            System.out.println("No available items found.");
            return;
        }
        System.out.println("Available Library Items:");

        libraryItemsList.forEach((item) -> {
            if (item.getStockQuantity() > 0) {
                System.out.println(item);
            }
        });
    }

    public void displayitem(int id) throws ItemNotFoundException {
        LibraryItem myItem = libraryItemsList.stream()
                .filter(item -> item.getID() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException());
        System.out.println(myItem);
    }

    // find
    public T findItemById(int id) throws ItemNotFoundException {
        if (libraryItemsList.isEmpty() || id < 0) {
            throw new ItemNotFoundException();
        }
        return libraryItemsList.stream()
                .filter((item) -> item.getID() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException());
    }

    // remove
    public void removeItem(int id) throws ItemNotFoundException {
        if (!libraryItemsList.removeIf(item -> item.getID() == id)) {
            throw new ItemNotFoundException();
        }
    }

    // update
    public void updateItem(int id, String title, String author, String year, int stock) throws ItemNotFoundException {
        int index = IntStream.range(0, libraryItemsList.size())
                .filter(i -> libraryItemsList.get(i).getID() == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException());

        libraryItemsList.get(index).setTitle(title);
        libraryItemsList.get(index).setAuthor(author);
        libraryItemsList.get(index).setYearPublished(year);
        libraryItemsList.get(index).setStockQuantity(stock);
    }

    public ArrayList<T> getLibraryItemsList() {
        return libraryItemsList;
    }

}
