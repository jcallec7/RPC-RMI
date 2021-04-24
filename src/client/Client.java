package client;

import server.ServerInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client extends UnicastRemoteObject implements ClientInterface, Runnable {

    private static final long serialVersionID = 1L;
    private ServerInterface chatServer;
    private String name = null;

    protected Client(String name, ServerInterface chatServer) throws RemoteException {
        this.name = name;
        this.chatServer = chatServer;
        chatServer.registerChatClient(this);
    }
    public void retrieveMessage(String message) throws RemoteException {
    	System.out.println(message);

    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String message;
        while (true) {
            message = scanner.nextLine();
            try {
                chatServer.broadcastMessage(name + " : " + message);

            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
