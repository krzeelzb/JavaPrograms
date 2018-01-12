package zadanie;

import java.io.*;
import java.net.*;
import java.util.*;


public class PooledConnectionHandler implements Runnable {
    protected Socket connection;
    protected static final List pool = new LinkedList();
    public PooledConnectionHandler() {
    }
    public void handleConnection() {
        try {
            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine, outputLine;
            KnockKnock commandProtocol = new KnockKnock();
            outputLine = "Witaj na serwerze, podaj komendę";
//            outputLine = commandProtocol.processInput(null);;

            out.println(outputLine);




            while ((inputLine = in.readLine()) != null) {
                commandProtocol.processInput(inputLine);
                out.println(commandProtocol.processInput(inputLine));
                if (commandProtocol.isQuitConnection()) {
                    out.println("koniec polaczenia");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find requested file on the server.");
        } catch (IOException e) {
            System.out.println("Error handling a client: " + e);
        }
    }
    public static void processRequest(Socket requestToHandle) {
        synchronized (pool) {
            pool.add(pool.size(), requestToHandle);
            pool.notifyAll();
        }
    }
    public void run() {
        while (true) {
            synchronized (pool) {
                while (pool.isEmpty()) {
                    try {
                        pool.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                connection = (Socket) pool.remove(0);
            }
            handleConnection();
        }
    }
}