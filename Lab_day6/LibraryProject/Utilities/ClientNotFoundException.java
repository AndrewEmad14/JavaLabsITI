package Lab_day6.LibraryProject.Utilities;

public class ClientNotFoundException extends Exception {
    public ClientNotFoundException() {
        super("Client doesnt Exsist");
    }

    public ClientNotFoundException(String message) {
        super(message);
    }

}
