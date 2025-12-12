package Lab_day6.LibraryProject.Client.Controller;

import Lab_day6.LibraryProject.Client.Model.Client;
import Lab_day6.LibraryProject.Library.Model.LibraryItem;

import java.util.ArrayList;

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
    public Client getClientByID(int clientID) {
        for (Client client : clientList) {
            if (client.getClientID() == clientID) {
                return client;
            }
        }
        return null;
    }

    // display
    public void displayClients() {
        System.out.println("Clients:");
        for (Client client : clientList) {
            System.out.println(client);
        }
    }

    // remove
    public void removeClient(int clientID) {
        clientList.removeIf(client -> client.getClientID() == clientID);
    }

    // update
    public void updateClient(int clientID, Client newClient) {
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).getClientID() == clientID) {
                clientList.set(i, newClient);
                return;
            }
        }
    }

    // borrow item
    public boolean borrowItem(int clientID, LibraryItem item) {
        Client client = getClientByID(clientID);
        if (client != null) {
            return client.addBorrowedItem(item);
        }
        return false;
    }

    // return item
    public boolean returnItem(int clientID, LibraryItem item) {
        Client client = getClientByID(clientID);
        if (client != null) {
            return client.returnBorrowedItem(item);
        }
        return false;
    }

}
