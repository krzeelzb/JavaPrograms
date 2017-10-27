package Zad4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cryptographer {
    public Cryptographer() {
    }

    public static String odczytajPlik(String nazwaPliku) {
        File plikDane = new File(nazwaPliku);
        String odczyt = "";
        try {
            Scanner skaner = new Scanner(plikDane);
            while (skaner.hasNextLine()) {
                odczyt = odczyt + skaner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak Pliku do odczytania!");
        }
        return odczyt;
    }
    public static void cryptfile(String toencrypt_, String savein_, Algorithm algo){
                String odczyt=odczytajPlik(toencrypt_);

        try {
            PrintWriter out = new PrintWriter(savein_);

            out.write(algo.crypt(odczyt));
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Niestety, nie mogę utworzyć pliku!");
        }

    }

    public static void decryptfile(String todecrypt_, String savein_, Algorithm algo){
        String odczyt=odczytajPlik(todecrypt_);


        try {
            PrintWriter out = new PrintWriter(savein_);
            out.println(algo.decrypt(odczyt));
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Niestety, nie mogę utworzyć pliku!");
        }
    }
}
//
//    public static void cryptfile(String toencrypt_, String savein_, int option){
//        String odczyt=odczytajPlik(toencrypt_);
//
//        try {
//            PrintWriter out = new PrintWriter(savein_);
//            if(option==1){
//                ROT11 algorithm= new ROT11();
//                String done=algorithm.crypt(odczyt);
//                System.out.println(done);
//                //out.println(algorithm.crypt("blaaa"));
//                out.write(done);
//            }
//            if (option==2){
//                Polibiusz algorithm= new Polibiusz();
//                out.println(algorithm.crypt(odczyt));
//            }
//            out.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Niestety, nie mogę utworzyć pliku!");
//        }
//
//    }
//
//    public static void decryptfile(String todecrypt_, String savein_, int option){
//        String odczyt=odczytajPlik(todecrypt_);
//
//
//        try {
//            PrintWriter out = new PrintWriter(savein_);
//            if(option==1){
//                ROT11 algorithm= new ROT11();
//                out.println(algorithm.decrypt(odczyt));
//            }
//            if (option==2){
//                Polibiusz algorithm= new Polibiusz();
//                out.println(algorithm.decrypt(odczyt));
//            }
//
//            out.close();
//        } catch (FileNotFoundException ex) {
//            System.out.println("Niestety, nie mogę utworzyć pliku!");
//        }
//
//
//    }
//}
