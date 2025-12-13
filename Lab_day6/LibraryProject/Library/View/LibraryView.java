package Lab_day6.LibraryProject.Library.View;

import java.util.InputMismatchException;
import java.util.Scanner;

import Lab_day6.LibraryProject.Library.Controller.LibraryController;
import Lab_day6.LibraryProject.Library.Model.Book;
import Lab_day6.LibraryProject.Library.Model.LibraryItem;
import Lab_day6.LibraryProject.Library.Model.Magazine;
import Lab_day6.LibraryProject.Utilities.Flusher;
import Lab_day6.LibraryProject.Utilities.ItemNotFoundException;
import Lab_day6.LibraryProject.Utilities.Validator;

public class LibraryView {
    private LibraryController<LibraryItem> libraryController;

    public LibraryView(LibraryController<LibraryItem> libraryController) {
        this.libraryController = libraryController;
    }

    public void optionView() {
        System.out.println("Library Options:");
        System.out.println("1. Add Library Item");
        System.out.println("2. Update Library Item");
        System.out.println("3. Delete Library Item");
        System.out.println("4. Find Library Item");
        System.out.println("5. Display Library Items");
        System.out.println("6. Go Back");
    }

    public void mainLibraryView() {
        Flusher.flush();
        System.out.println("Welcome to the Library Management System");

        Boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);
        while (isRunning) {
            optionView();
            System.out.println("Please select an option:");
            int choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Add Library Item selected");
                        System.out.println("Enter Title:");
                        String title = scanner.next();
                        System.out.println("Enter Author:");
                        String author = scanner.next();
                        if (Validator.isValidName(author) == false) {
                            throw new IllegalArgumentException("Invalid Author Name Format");
                        }
                        System.out.println("Enter Stock Quantity:");
                        int stockQuantity = scanner.nextInt();
                        if (stockQuantity < 0) {
                            throw new IllegalArgumentException("Stock Quantity cannot be negative");
                        }
                        System.out.println("Enter Year Published:");
                        String yearPublished = scanner.next();
                        if (Validator.isVaildYear(yearPublished) == false) {
                            throw new IllegalArgumentException("Invalid Year Published Format");
                        }
                        System.out.println("Choose Item Type: 1. Book 2. Magazine");
                        int itemType = scanner.nextInt();
                        if (itemType == 1) {
                            Book newBook = new Book(title, author, yearPublished, stockQuantity);
                            libraryController.addItem(newBook);
                        } else if (itemType == 2) {
                            Magazine newMagazine = new Magazine(title, author, yearPublished, stockQuantity);
                            libraryController.addItem(newMagazine);
                        } else {
                            throw new IllegalArgumentException("Invalid Item Type selected");
                        }
                        System.out.println("Library Item added successfully.");
                        break;
                    case 2:
                        System.out.println("Update Library Item selected");
                        System.out.println("Enter Item ID to update:");
                        Integer itemId = scanner.nextInt();
                        libraryController.findItemById(itemId);
                        System.out.println("Enter new Title:");
                        String newTitle = scanner.next();
                        System.out.println("Enter new Author:");
                        String newAuthor = scanner.next();
                        if (Validator.isValidName(newAuthor) == false) {
                            throw new IllegalArgumentException("Invalid Author Name Format");
                        }
                        System.out.println("Enter new Stock Quantity:");
                        int newStockQuantity = scanner.nextInt();
                        if (newStockQuantity < 0) {
                            throw new IllegalArgumentException("Stock Quantity cannot be negative");
                        }
                        System.out.println("Enter new Year Published:");
                        String newYearPublished = scanner.next();
                        if (Validator.isVaildYear(newYearPublished) == false) {
                            throw new IllegalArgumentException("Invalid Year Published Format");
                        }
                        System.out.println("Enter Item Type: 1. Book 2. Magazine");
                        int newItemType = scanner.nextInt();
                        if (newItemType == 1) {
                            libraryController.updateItem(itemId, newTitle, newAuthor, newYearPublished,
                                    newStockQuantity);
                        } else if (newItemType == 2) {
                            libraryController.updateItem(itemId, newTitle, newAuthor, newYearPublished,
                                    newStockQuantity);
                        } else {
                            throw new IllegalArgumentException("Invalid Item Type selected");
                        }
                        System.out.println("Library Item updated successfully.");
                        break;
                    case 3:
                        System.out.println("Delete Library Item selected");
                        System.out.println("Enter Item ID to delete:");
                        Integer deleteItemId = scanner.nextInt();
                        libraryController.removeItem(deleteItemId);
                        System.out.println("Library Item deleted successfully.");
                        break;
                    case 4:
                        System.out.println("Find Library Item selected");
                        System.out.println("Enter Item ID to find:");
                        Integer findItemId = scanner.nextInt();
                        libraryController.displayitem(findItemId);
                        System.out.println("Library Item found successfully.");
                        break;
                    case 5:
                        System.out.println("Display Library Items selected");
                        libraryController.displayItemList();
                        break;
                    case 6:
                        System.out.println("Going back to main menu.");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.next(); // Clear the invalid input
            } catch (ItemNotFoundException e) {
                System.out.println("An error occurred: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

        }
    }

}
