package zadanie;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Scanner;

public class Client {

    private static String found = "";
    private static int passLength = 0;
    private static int lev = 100;

    public static void main(String[] args) throws IOException {


        try (
                Socket kkSocket = new Socket("localhost", 3000);
                PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(kkSocket.getInputStream()));

                FileInputStream dataFStream = new FileInputStream(new File("/home/ela/Pulpit/lab9/src/zadanie/polish-dic.txt"));
                DataInputStream dataIStream = new DataInputStream(dataFStream);
                BufferedReader dataBFR = new BufferedReader(new InputStreamReader(dataIStream));
        ) {

            BufferedReader stdIn =
                    new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromUser;


            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("zalogowano")){
                    fromUser = found;
                    System.out.println("Client: " + fromUser);
                    out.println("hasło:"+fromUser);
                     break;
            }
                if (fromServer.equals("Wylogowano"))
                    break;
                if (passLength == 0 && isNumeric(fromServer)) {
                    passLength = Integer.parseInt(fromServer);
                    lev = Integer.parseInt(fromServer);
                }

                if (passLength > 0) {
                    File plik = new File("/home/ela/Pulpit/lab9/src/zadanie/polish-dic.txt");
                    LinkedList<String> has = new LinkedList<String>();
                    Scanner odczyt = new Scanner(plik);
                    //String pierwszy = odczyt.nextLine();
//                    out.println("LOGIN Szymon;"+pierwszy);
                    //out.println(" ");
                    String haslo;
                    if(has.size()==0){
                        while (odczyt.hasNextLine()) {
                            haslo = odczyt.nextLine();
                            if (haslo.length()==lev){
                                has.add(haslo);
                            }
                        }
                    }
                   System.out.println(has);
                    for (int i = 0; i < has.size(); i++) {
//                        out.println("LOGIN Szymon;" + has.get(i));
//                        System.out.println(has.get(i));
                        out.println(has.get(i));
                        found=has.get(i);
                        String read=in.readLine();
                        System.out.println(read);
                        if (read.equals("zalogowano")) {
                            found=has.get(i);
                            System.out.println("Client: Znaleziono hasło: "+has.get(i));
                            break;
                            }
                        }
                    }

                fromUser = found;
                System.out.println("Client: " + fromUser);
                out.println(fromUser);
                }

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host ");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to ");
            System.exit(1);
        }
    }

    public static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String replace(String str, int index, char replace) {
        if (str == null) {
            return str;
        } else if (index < 0 || index >= str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        chars[index] = replace;
        return String.valueOf(chars);
    }
    public static int Lav(String a, String b){
        int[] costs = new int[b.length() + 1];
        for (int j = 0; j < costs.length; j++)
            costs[j] = j;
        for (int i = 1; i <= a.length(); i++) {
            // j == 0; nw = lev(i - 1, j)
            costs[0] = i;
            int nw = i - 1;
            for (int j = 1; j <= b.length(); j++) {
                int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
                nw = costs[j];
                costs[j] = cj;
            }
        }
        int wynik=costs[b.length()];
        return wynik;
    }
}