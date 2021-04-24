package server;

import client.ClientInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerInterface extends Remote {

    void registerChatClient(ClientInterface chatClient) throws RemoteException;
    void broadcastMessage(String message) throws RemoteException;

}
