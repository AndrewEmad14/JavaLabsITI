package Lab_day6.LibraryProject.Utilities;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException() {
        super("Item doesnt Exsist");
    }

    public ItemNotFoundException(String message) {
        super(message);
    }
}
