package zad1.javaIn;

import java.io.*;

public class JIn {
    public static String getString() {
        String text = null;

        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            text = bfr.readLine();

        }catch(IOException e){e.printStackTrace();}
        return text;
    }


    public static double getDouble(){

        double number=0;
        try{
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader bfr = new BufferedReader(rd);

            number =Double.parseDouble(bfr.readLine());

        }catch(IOException e){e.printStackTrace();}
        return number;

    }
}