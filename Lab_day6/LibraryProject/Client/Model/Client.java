package Lab_day6.LibraryProject.Client.Model;

import java.util.ArrayList;

import Lab_day6.LibraryProject.Library.Model.LibraryItem;

public class Client {

    private String name;
    private String email;
    private static int clientCounter = 0;
    private int clientID;
    private ArrayList<LibraryItem> borrowedItems = new ArrayList<>();

    public Client(String name, String email, ArrayList<LibraryItem> borrowedItems) {
        this.name = name;
        this.email = email;
        this.clientID = clientCounter;
        clientCounter++;
        this.borrowedItems = borrowedItems;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBorrowedItems(ArrayList<LibraryItem> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public Boolean addBorrowedItem(LibraryItem item) {
        if (item.getStockQuantity() > 0) {
            borrowedItems.add(item);
            item.setStockQuantity(item.getStockQuantity() - 1);
            return true;
        }
        return false;

    }

    public Boolean returnBorrowedItem(LibraryItem item) {
        if (borrowedItems.remove(item)) {
            item.setStockQuantity(item.getStockQuantity() + 1);
            return true;
        }
        return false;
    }

    public int getClientID() {
        return clientID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    @Override
    public String toString() {
        return "Client ID: " + clientID + ", Name: " + name + ", Email: " + email;
    }
}