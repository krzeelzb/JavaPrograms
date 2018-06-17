import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        //Nawiązanie połączenia z serwerem www.wikipedia.org
        //na porcie 80, czyli z serwerem webowym
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("www.wikipedia.org", 80));
        //poniżej utworzenie obiektu i nawiązanie połączenia w jednej lini
        //Socket socket = new Socket("www.wikipedia.org", 80);

        //Opakowanie strumienia wychodzącego
        //w obiekt PrintWriter zapewnia operację na stringach i wspiera kodowanie znaków
        PrintWriter out = new PrintWriter(
                //Filtr wstawiający znak CR przed każdym wystąpieniem znaku LF
                //(zgodnie z wymogami protokołu HTTP, a w przeciwieństwie do konwencji używanej w Javie
                new CarriageReturnFilter(
                        //Buforowanie strumienia wychodzącego
                        new BufferedWriter(
                                //Adapter OutputStream do Writer
                                new OutputStreamWriter(
                                        socket.getOutputStream()))));

        //Wysłanie zapytania GET protokołu HTTP
        //do serwera www.wikipedia.org
        out.println("GET / HTTP/1.1");
        out.println("Host: www.wikipedia.org");
        out.println();
        out.flush();

        //Sprawdzenie, czy nie nastąpił błąd podczas komunikacji
        if (out.checkError())
            System.out.println(
                    "SocketClient:  java.io.PrintWriter error");

        //Pobranie danych przychodzących z serwera www
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));

        //Wypisanie odpowiedzi nadesłanej z serwera
        //(w przypadku powodzenia operacji strona główna wikipedii plus nagłówek HTTP
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);

        //Zamknięcie strumieni i gniazda sieciowego
        in.close();
        out.close();
        socket.close();
    }
}

class CarriageReturnFilter extends FilterWriter {

    public CarriageReturnFilter(Writer out) {
        super(out);
    }

    public void write(int c) throws IOException {
        if( c == '\n' )
            out.write('\r');
        out.write(c);
    }

}

class SockReader implements Runnable {
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
        msg("new connection");
        while( (!Thread.currentThread().isInterrupted()) && in.hasNext() ) {
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