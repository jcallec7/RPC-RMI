package client;

import server.ServerInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientDriver {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String chatServerURL = "rmi://localhost/RMIChatServer";
        ServerInterface chatServer = (ServerInterface) Naming.lookup(chatServerURL);
        new Thread(new Client(args[0], chatServer)).start();
    }
}
