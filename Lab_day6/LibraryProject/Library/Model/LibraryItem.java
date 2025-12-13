package Lab_day6.LibraryProject.Library.Model;

public abstract class LibraryItem {
    protected int id;
    protected String title; // Title of the item
    protected String author; // Author/Creator/Director
    protected String yearPublished; // Year of publication/release
    protected static int idCounter = 0;
    protected int stockQuantity = 1; // Number of copies available in the library

    public LibraryItem(String title, String author, String yearPublished, int stockQuantity) {
        this.id = idCounter;
        idCounter++;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
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

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getYearPublished() {
        return yearPublished;
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