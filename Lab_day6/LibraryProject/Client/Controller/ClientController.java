package Lab_day6.LibraryProject.Client.Controller;

import Lab_day6.LibraryProject.Client.Model.Client;
import Lab_day6.LibraryProject.Library.Model.LibraryItem;
import Lab_day6.LibraryProject.Utilities.ClientNotFoundException;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class ClientController {

    private ArrayList<Client> clientList = new ArrayList<>();

    // create
    public void addClient(Client client) {
        clientList.add(client);
    }

    // retrieveAll
    public ArrayList<Client> getClientList() {
        return clientList;
    }

    // retrieveByID
    public Client findClientById(int clientID) throws ClientNotFoundException {
        return clientList.stream()
                .filter(client -> client.getClientID() == clientID)
                .findFirst()
                .orElseThrow(() -> new ClientNotFoundException());

    }

    // display
    public void displayClients() {
        System.out.println("Clients:");
        if (clientList.isEmpty()) {
            System.out.println("No clients found.");
            return;
        }
        clientList.forEach((client) -> System.out.println(client));
    }

    public void displayClient(int clientID) throws ClientNotFoundException {
        Client myClient = clientList.stream()
                .filter(client -> client.getClientID() == clientID)
                .findFirst()
                .orElseThrow(() -> new ClientNotFoundException());
        System.out.println(myClient);
    }

    // remove
    public void removeClient(int clientID) throws ClientNotFoundException {
        if (!clientList.removeIf(client -> client.getClientID() == clientID)) {
            throw new ClientNotFoundException();
        }
    }

    // update
    public void updateClient(int clientID, String name, String email, ArrayList<LibraryItem> borrowedItems)
            throws ClientNotFoundException {
        int index = IntStream.range(0, clientList.size())
                .filter(i -> clientList.get(i).getClientID() == clientID)
                .findFirst()
                .orElseThrow(() -> new ClientNotFoundException());
        clientList.get(index).setName(name);
        clientList.get(index).setEmail(email);
        clientList.get(index).setBorrowedItems(borrowedItems);
    }

    // borrow item
    public void borrowItem(int clientID, LibraryItem item) {
        try {
            findClientById(clientID).addBorrowedItem(item);
        } catch (ClientNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void displayBorrowedItems(int clientID) {
        try {
            findClientById(clientID).displayBorrowedItems();
        } catch (ClientNotFoundException e) {
            e.printStackTrace();
        }
    }

    // return item
    public void returnItem(int clientID, LibraryItem item) {
        try {
            findClientById(clientID).returnBorrowedItem(item);
        } catch (ClientNotFoundException e) {
            e.printStackTrace();
        }
    }

}
