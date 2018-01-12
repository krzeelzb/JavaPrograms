package zadanie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.Socket;
import java.util.Scanner;

public class KnockKnockBasic {
    private static final int WAITING = 0;
    private static final int INPUTLOGIN = 1;
    private static final int INPUTPASS = 2;
    private static final int ANOTHER = 3;

    private int state = INPUTLOGIN;

    private String login = "szymon";
    private String pass = "pass";
    private boolean message ;
    private boolean quitConnection=false ;
    boolean czyZalogowany=false;
    private Socket clientSocket;
    private BufferedReader in = null;
    private int tmp=0;



    public String processInput(String theInput) throws FileNotFoundException {
        String theOutput = null;




//
            String[] parts = theInput.split(" ");
            String[] parts2=new String[4];

            if(parts.length>1) {
               parts2 = parts[1].split(";");
            }

            if (parts[0].equals("LOGIN") && state == INPUTLOGIN) {
                 if (parts2[0].equals(login) && parts2[1].equals(pass)) {
                     theOutput = "Logowanie poprawne. Wpisz komendę";
                     czyZalogowany = true;
                     state = ANOTHER;

                 } else {
                     if (!parts2[0].equals(login)) {
                         theOutput = "Zly login.Sprobuj jeszcze raz";
                         state = INPUTLOGIN;
                     }
                     if (!parts2[1].equals(pass)) {
                         theOutput = "Niepoprawne haslo. Liczba Levenstheina: " + computeLevenshteinDistance(pass, parts2[1]) + " Podaj login";
                         state = INPUTLOGIN;
                     }
                 }
             }




         else if (parts[0].equals("LS")) {
            File katalog = new File("/home/ela/Pulpit/lab9");
            String pliki[] = katalog.list();
            String tmp = "";

            for (int i = 0; i < pliki.length; i++) {
                tmp += pliki[i] + " ";
            }
            theOutput = tmp;

        } else if (parts[0].equals("GET") && parts[1].equals(login)) {
            File file = new File(parts[2]);
            Scanner in = new Scanner(file);
            String zdanie = in.nextLine();
            theOutput = zdanie;
        } else if (parts[0].equals("LOGOUT") && parts[1].equals(login)) {
            theOutput = "Bye!";
            System.exit(0);

        }else {
            theOutput = "Niepowodzenie! Wpisz poprawną komendę";
            state = ANOTHER;
        }

        return theOutput;
    }


    private static int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static int computeLevenshteinDistance(CharSequence lhs, CharSequence rhs) {
        int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];

        for (int i = 0; i <= lhs.length(); i++)
            distance[i][0] = i;
        for (int j = 1; j <= rhs.length(); j++)
            distance[0][j] = j;

        for (int i = 1; i <= lhs.length(); i++)
            for (int j = 1; j <= rhs.length(); j++)
                distance[i][j] = minimum(
                        distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));

        return distance[lhs.length()][rhs.length()];
    }


    public boolean getMessage() {
        return message;
    }

    public boolean isQuitConnection() {
        return quitConnection;
    }
}

