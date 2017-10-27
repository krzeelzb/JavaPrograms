package Zad4;

import java.util.Scanner;

public class Main {
    public static void main(String[] argv) {
        System.out.println("Podaj ścieżkę do pliku wjeściowego:");
        String input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        System.out.println("Podaj ścieżkę do pliku wyjściowego:");
        String output;
        Scanner scanner2 = new Scanner(System.in);
        output = scanner2.nextLine();

        System.out.println("Co chcesz zrobić:\n" +
                "1.szyfrować\n" +
                "2.deszyfrować");
        int whattodo;
        Scanner scanner3 = new Scanner(System.in);
        whattodo = scanner3.nextInt();


        System.out.println("Jakim algorytmem:\n" +
                "1.ROT11\n" +
                "2.Polibius");
        int whichalgo;
        Scanner scanner4 = new Scanner(System.in);
        whichalgo = scanner4.nextInt();

        switch (whattodo) {
            case 1: {//cypher
                switch (whichalgo) {
                    case 1: { //ROT11
//                        Cryptographer.cryptfile("/home/ela/Pulpit/1.txt","/home/ela/Pulpit/2.txt",new ROT11());
                       Cryptographer.cryptfile(input,output,new ROT11());
                        break;
                    }
                    case 2: {//Polibus
//                        Cryptographer.cryptfile("/home/ela/Pulpit/1.txt","/home/ela/Pulpit/2.txt",new Polibiusz());
                        Cryptographer.cryptfile(input,output,new Polibiusz());
                        break;

                    }
                }
            break;
            }
            case 2: { //decypher
                switch (whichalgo) {
                    case 1: { //ROT11
//                        Cryptographer.decryptfile("/home/ela/Pulpit/2.txt","/home/ela/Pulpit/1.txt",new ROT11());
                        Cryptographer.decryptfile(input,output,new ROT11());
                        break;
                    }
                    case 2: {//Polibus
//                        Cryptographer.decryptfile("/home/ela/Pulpit/2.txt","/home/ela/Pulpit/1.txt",new Polibiusz());
                        Cryptographer.decryptfile(input,output,new Polibiusz());
                        break;
                    }
                }
                break;

            }
        }
    }
}
