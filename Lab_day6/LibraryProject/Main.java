package Lab_day6.LibraryProject;

import java.nio.channels.ClosedByInterruptException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.BlockElement;

import Lab_day6.LibraryProject.Client.Model.Client;
import Lab_day6.LibraryProject.Client.View.ClientView;
import Lab_day6.LibraryProject.Library.Controller.LibraryController;
import Lab_day6.LibraryProject.Library.View.LibraryView;
import Lab_day6.LibraryProject.Utilities.Flusher;
import Lab_day6.LibraryProject.Client.Controller.ClientController;

public class Main {
    public static void runLibaryManagement() {
        Flusher.flush();
        ClientController clientController = new ClientController();
        LibraryController libraryController = new LibraryController();
        LibraryView libraryView = new LibraryView(libraryController);
        ClientView clientView = new ClientView(clientController, libraryController);

        Boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            Flusher.flush();
            try {
                System.out.println("Select Mode: 1. Client Management 2. Library Management 3. Exit");
                int modeChoice = scanner.nextInt();
                switch (modeChoice) {
                    case 1:
                        clientView.mainClientView();
                        break;
                    case 2:
                        libraryView.mainLibraryView();
                        break;
                    case 3:
                        isRunning = false;
                        System.out.println("Exiting the system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();

            }

        }
        scanner.close();

    }

    public static void main(String args[]) {
        runLibaryManagement();

    }
}
