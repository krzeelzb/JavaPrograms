package pesel;

import zad1.javaIn.JIn;

public class PeselProgram {
    public static void main(String [] argv){
        System.out.print("Type your Pesel: ");
        String pesel = JIn.getString();
        Pesel peseltocheck=new Pesel(pesel);

        peseltocheck.check(pesel);


    }
}
