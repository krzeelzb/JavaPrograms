package zadanie;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class KnockKnockServer {
    public static void main(String[] args) throws IOException {
        try (
                ServerSocket serverSocket = new ServerSocket(6666);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
        ) {

            String inputLine, outputLine;

            // Initiate conversation with client
            KnockKnockBasic kkp = new KnockKnockBasic();
            outputLine = kkp.processInput("Witaj!");
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if (outputLine.equals("Bye."))
                    break;
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port 6666 or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

 static class SockReader implements Runnable {
    private Scanner in;
    private PrintStream out;
    private Socket s;

    public SockReader(Socket s) throws IOException {
        this(s.getInputStream(),s.getOutputStream());
        this.s = s;
    }

    public SockReader(InputStream input,OutputStream output) {
        in = new Scanner(input);
        out = new PrintStream(output);
    }

    private void msg(String msg) {
        System.out.print("SRV: ");
        System.out.println(msg);
    }
    public void run() {
        msg("serving new connection");
        while( (!Thread.currentThread().isInterrupted()) && in.hasNextLine() ) {
            String line = in.nextLine();
            msg(line);
            out.println(line);
        }
        try {
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        msg("connection closed");
    }
}
}
