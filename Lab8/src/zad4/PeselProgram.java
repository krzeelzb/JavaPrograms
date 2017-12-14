package zad4;



import java.util.Scanner;

public class PeselProgram {
    public static void main(String [] argv){
        System.out.print("Type your Pesel: ");
        String pesel;
        Scanner odczyt = new Scanner(System.in);

        pesel = odczyt.nextLine();
        Pesel peseltocheck=new Pesel(pesel);

        peseltocheck.check(pesel);


    }
}
