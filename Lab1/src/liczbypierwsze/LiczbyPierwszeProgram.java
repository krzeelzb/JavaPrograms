package liczbypierwsze;

import zad1.javaIn.JIn;

public class LiczbyPierwszeProgram {
    public static void main(String[] argv){
        System.out.print("Type the number: ");
        double number = JIn.getDouble();
        LiczbyPierwsze numb= new LiczbyPierwsze(number);
        numb.search(number);


    }
}
