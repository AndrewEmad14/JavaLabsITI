package Lab_day6.LibraryProject.Library.Model;

import java.time.LocalDate;

public abstract class LibraryItem {
    protected int id;
    protected String title; // Title of the item
    protected String author; // Author/Creator/Director
    protected int yearPublished; // Year of publication/release
    protected int borrowedByClientID = -1; // ID of the client who borrowed the item, -1 if not borrowed
    protected static int idCounter = 0;
    protected int stockQuantity = 1; // Number of copies available in the library

    public LibraryItem(String title, String author, int yearPublished, int borrowedByClientID,
            int stockQuantity) {
        this.id = idCounter;
        idCounter++;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.borrowedByClientID = borrowedByClientID;
        this.stockQuantity = stockQuantity;
    }

    public int getID() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setBorrowedByClientID(int borrowedByClientID) {
        this.borrowedByClientID = borrowedByClientID;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public int getBorrowedByClientID() {
        return borrowedByClientID;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public abstract String toString();
}