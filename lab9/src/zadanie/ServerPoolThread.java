package zadanie;

import java.io.*;
import java.net.*;

public class ServerPoolThread {
    protected int maxConnections;
    protected int listenPort;
    protected ServerSocket serverSocket;

    public ServerPoolThread(int aListenPort, int maxConnections) {
        listenPort = aListenPort;
        this.maxConnections = maxConnections;
    }

    public void acceptConnections() {
        try {
            ServerSocket server = new ServerSocket(listenPort);
            Socket incomingConnection = null;
            while (true) {
                System.out.println("polaczono");
                incomingConnection = server.accept();
                handleConnection(incomingConnection);

            }
        } catch (BindException e) {
            System.out.println("Unable to bind to port " + listenPort);
        } catch (IOException e) {
            System.out.println("Unable to instantiate a ServerSocket on port: " + listenPort);
        }
    }

    protected void handleConnection(Socket connectionToHandle) {
        PooledConnectionHandler.processRequest(connectionToHandle);
    }

    public static void main(String[] args) {
        ServerPoolThread server = new ServerPoolThread(3000, 2);
        System.out.println("start");
        server.setUpHandlers();
        server.acceptConnections();
    }

    public void setUpHandlers() {
        for (int i = 0; i < maxConnections; i++) {
            PooledConnectionHandler currentHandler = new PooledConnectionHandler();
            new Thread(currentHandler, "Handler " + i).start();
        }
    }



}

