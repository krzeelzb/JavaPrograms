import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public class sslSocket {


    public static void main(String[] args) throws Exception {

        try {
            SSLSocketFactory factory =
                    (SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocket socket =
                    (SSLSocket)factory.createSocket("www.verisign.com", 443);

	    /*
	     * send http request
	     *
	     * Before any application data is sent or received, the
	     * SSL socket will do SSL handshaking first to set up
	     * the security attributes.
	     *
	     * SSL handshaking can be initiated by either flushing data
	     * down the pipe, or by starting the handshaking by hand.
	     *
	     * Handshaking is started manually in this example because
	     * PrintWriter catches all IOExceptions (including
	     * SSLExceptions), sets an internal error flag, and then
	     * returns without rethrowing the exception.
	     *
	     * Unfortunately, this means any error messages are lost,
	     * which caused lots of confusion for others using this
	     * code.  The only way to tell there was an error is to call
	     * PrintWriter.checkError().
	     */
            socket.startHandshake();

            PrintWriter out = new PrintWriter(
                    new CarriageReturnFilter(
                            new BufferedWriter(
                                    new OutputStreamWriter(
                                            socket.getOutputStream()))));

            out.println("GET / HTTP/1.1");
            out.println("Host: www.verisign.com");
            out.println();
            out.flush();

	    /*
	     * Make sure there were no surprises
	     */
            if (out.checkError())
                System.out.println(
                        "SSLSocketClient:  java.io.PrintWriter error");

	    /* read response */
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);

            in.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}