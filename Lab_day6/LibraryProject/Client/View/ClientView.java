package Lab_day6.LibraryProject.Client.View;

import Lab_day6.LibraryProject.Client.Controller.ClientController;
import Lab_day6.LibraryProject.Client.Model.Client;
import Lab_day6.LibraryProject.Library.Controller.LibraryController;
import Lab_day6.LibraryProject.Library.Model.LibraryItem;
import Lab_day6.LibraryProject.Utilities.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Lab_day6.LibraryProject.Client.Model.Client;

public class ClientView {
    private static ClientView instance;
    private ClientController clientController = new ClientController();
    private LibraryController libraryController = new LibraryController();

    public ClientView(ClientController clientController, LibraryController libraryController) {
        this.clientController = clientController;
        this.libraryController = libraryController;

    }

    public void optionView() {
        System.out.println("1. Add Client");
        System.out.println("2. Remove Client");
        System.out.println("3. Update Client");
        System.out.println("4. Borrow Item");
        System.out.println("5. Return Item");
        System.out.println("6. Find Client");
        System.out.println("7. View All Clients");
        System.out.println("8.Go Back");
    }

    public void mainClientView() {
        Flusher.flush();
        System.out.println("Welcome to the Library Client Management System");

        Scanner scanner = new Scanner(System.in);
        Boolean isRunning = true;
        while (isRunning) {
            try {
                optionView();
                System.out.println("Please select an option:");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Add Client selected");
                        System.out.println("Enter Client Name:");
                        String name = scanner.next(); // Example name
                        if (Validator.isValidName(name) == false) {
                            throw new IllegalArgumentException("Invalid Name Format");
                        }
                        System.out.println("Enter Client Email:");
                        String email = scanner.next();
                        if (Validator.isValidEmail(email) == false) {
                            throw new IllegalArgumentException("Invalid Email Format");
                        }
                        ArrayList<LibraryItem> borrowedItems = new ArrayList<>();
                        Client newClient = new Client(name, email, borrowedItems);
                        clientController.addClient(newClient);
                        System.out.println("Client added successfully.");
                        break;
                    case 2:
                        System.out.println("Remove Client selected");
                        System.out.println("Enter Client ID to remove:");
                        Integer clientId = scanner.nextInt();
                        clientController.removeClient(clientId);
                        System.out.println("Client removed successfully.");
                        break;
                    case 3:
                        System.out.println("Update Client selected");
                        // Update Client logic here
                        System.out.println("Enter Client ID to update:");
                        Integer updatedClientId = scanner.nextInt();
                        System.out.println("Enter new Client Name:");
                        String updatedName = scanner.next();
                        if (Validator.isValidName(updatedName) == false) {
                            throw new IllegalArgumentException("Invalid Name Format");
                        }
                        System.out.println("Enter new Client Email:");
                        String updatedEmail = scanner.next();
                        if (Validator.isValidEmail(updatedEmail) == false) {
                            throw new IllegalArgumentException("Invalid Email Format");
                        }
                        ArrayList<LibraryItem> updatedBorrowedItems = new ArrayList<>();
                        clientController.updateClient(updatedClientId, updatedName, updatedEmail, updatedBorrowedItems);
                        System.out.println("Client updated successfully.");
                        break;
                    case 4:
                        System.out.println("Borrow Item selected");
                        // Borrow Item logic here
                        System.out.println("Enter Client ID to borrow item:");
                        Integer borrowerClientId = scanner.nextInt();
                        libraryController.displayAvailableItems();
                        System.out.println("Enter Item ID to borrow:");
                        Integer itemIdToBorrow = scanner.nextInt();
                        clientController.findClientById(borrowerClientId)
                                .addBorrowedItem(libraryController.getItem(itemIdToBorrow));
                        System.out.println("Item borrowed successfully.");
                        break;
                    case 5:
                        System.out.println("Return Item selected");
                        System.out.println("Enter Client ID to borrow item:");

                        Integer returnerClientId = scanner.nextInt();

                        System.out.println("Borrowed Items:");
                        clientController.displayBorrowedItems(returnerClientId);
                        System.out.println("Enter Item ID to return:");
                        Integer itemIdToReturn = scanner.nextInt();
                        clientController.findClientById(returnerClientId)
                                .returnBorrowedItem(libraryController.getItem(itemIdToReturn));
                        System.out.println("Item returned successfully.");
                        break;
                    case 6:
                        System.out.println("Find Client selected");
                        System.out.println("Enter Client ID to find:");
                        Integer clientIdToFind = scanner.nextInt();
                        clientController.displayClient(clientIdToFind);
                        break;
                    case 7:
                        System.out.println("View All Clients selected");
                        clientController.displayClients();
                        break;
                    case 8:
                        System.out.println("Going back to main menu.");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.next(); // Clear the invalid input
            } catch (ClientNotFoundException e) {
                System.out.println("An error occurred: " + e.getMessage());
            } catch (ItemNotFoundException e) {
                System.out.println("An error occurred: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

        }
    }

}
