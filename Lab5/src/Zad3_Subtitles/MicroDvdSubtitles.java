package Zad3_Subtitles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

public class MicroDvdSubtitles {
    protected String input_, output_;
    int delay_, ftp_;
    String invalid_arguement_;

    public MicroDvdSubtitles() {
    }

    public MicroDvdSubtitles(String input_, String output_) {
        this.input_ = input_;
        this.output_ = output_;
    }

    public void delay(String in, String out_, int delay, int fps) throws InvalidSubtitleLineFormat, SubtitleEndBeforeStart, NegativeFrameAfterShift, InvalidSubtitleLine {
        File plikDane = new File(in);
        String odczyt = "";
        String output = "";
        int move = (int) Math.floor((fps * delay) / 1000);
        Vector<Integer> whichLine = new Vector<Integer>();
        Vector<String> line = new Vector<String>();
        int j = 1;
        String tmp = "";
        Vector<String> vec_input = new Vector<>();
        try {
            Scanner skaner = new Scanner(plikDane);
            while (skaner.hasNextLine()) {
                String odczyttmp =  skaner.nextLine();
                odczyt += odczyttmp;
                odczyt+="\n";
                whichLine.add(j);
                j++;
                line.add(odczyt);
                for (int i = 0; i < odczyttmp.length(); i++) {
                    if (odczyttmp.charAt(i) == '{') {
                        i++;
                        while (odczyttmp.charAt(i) != '}') {
                            if (odczyttmp.charAt(i) <= 57 & 48 <= odczyttmp.charAt(i)) {
                                tmp += odczyttmp.charAt(i);
                                i++;
                            } else
                                throw new InvalidSubtitleLineFormat(j, odczyttmp);
                        }
                        vec_input.add(tmp);
                    }
                    tmp = "";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Brak Pliku do odczytania!");
        }
        if (vec_input.size() % 2 != 0)
            throw new InvalidSubtitleLine();

            for (int i = 0; i < vec_input.size(); i += 2) {
                if ((Integer.parseInt(vec_input.get(i)) > (Integer.parseInt(vec_input.get(i + 1)))))
                    throw new SubtitleEndBeforeStart(i, vec_input.get(i), vec_input.get(i + 1));
            }

        for (int i = 0; i < odczyt.length(); i++) {
            output+=odczyt.charAt(i);
            if (odczyt.charAt(i) == '{') {
                while (odczyt.charAt(i) != '}') {
                    i++;
                }
                String newvalue = Integer.toString(Integer.parseInt(vec_input.elementAt(0)) + move);
                output += newvalue;
                output += '}';
                vec_input.remove(vec_input.firstElement());
            }
        }


        if (delay < 0)
            throw new NegativeFrameAfterShift();

        if (fps < 0)
            throw new NegativeFrameAfterShift();

        try {
            PrintWriter out = new PrintWriter(out_);
            out.write(output);
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Niestety, nie mogę utworzyć pliku!");
        }
    }
}



