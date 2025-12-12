package Lab_day6.LibraryProject.Library.Model;

public class Book extends LibraryItem {

    public Book(String title, String author, int yearPublished, int borrowedByClientID, int stockQuantity) {
        super(title, author, yearPublished, borrowedByClientID, stockQuantity);
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder();
        details.append("Book ID: " + this.id);
        details.append("Title: " + this.title);
        details.append("Author: " + this.author);
        details.append("Year Published: " + this.yearPublished);
        details.append("Stock: " + (this.stockQuantity));
        return details.toString();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getYearPublished() {
        return this.yearPublished;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getStockQuantity() {
        return this.stockQuantity;
    }

}
