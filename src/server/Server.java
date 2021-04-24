package server;

import client.ClientInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements ServerInterface{

    private static final long serialVersionUID = 1L;
    private ArrayList<ClientInterface> chatClients;

    protected Server() throws RemoteException {
    	this.chatClients = new ArrayList<ClientInterface>();
    }

    public synchronized void registerChatClient(ClientInterface chatClient) throws RemoteException {
        this.chatClients.add(chatClient);
    }

    public synchronized void broadcastMessage(String message) throws RemoteException {
        int i=0;
        while (i<this.chatClients.size()){
            this.chatClients.get(i++).retrieveMessage(message);
        }
    }
}
