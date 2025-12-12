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
    public Client getClientByID(int clientID) throws ClientNotFoundException {
        return clientList.stream()
                .filter(client -> client.getClientID() == clientID)
                .findFirst()
                .orElseThrow(() -> new ClientNotFoundException());

    }

    // display
    public void displayClients() {
        System.out.println("Clients:");
        clientList.forEach((client) -> System.out.println(client));
    }

    // remove
    public Boolean removeClient(int clientID) {
        return clientList.removeIf(client -> client.getClientID() == clientID);
    }

    // update
    public void updateClient(int clientID, Client newClient) throws ClientNotFoundException {
        int index = IntStream.range(0, clientList.size())
                .filter(i -> clientList.get(i).getClientID() == clientID)
                .findFirst()
                .orElseThrow(() -> new ClientNotFoundException());
        clientList.set(index, newClient);
    }

    // borrow item
    public void borrowItem(int clientID, LibraryItem item) {
        try {
            getClientByID(clientID).addBorrowedItem(item);
        } catch (ClientNotFoundException e) {
            e.printStackTrace();
        }
    }

    // return item
    public void returnItem(int clientID, LibraryItem item) {
        try {
            getClientByID(clientID).returnBorrowedItem(item);
        } catch (ClientNotFoundException e) {
            e.printStackTrace();
        }
    }

}
