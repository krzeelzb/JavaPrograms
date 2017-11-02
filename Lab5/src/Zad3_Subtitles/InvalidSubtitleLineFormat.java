package Zad3_Subtitles;

public class InvalidSubtitleLineFormat extends Throwable {
    public InvalidSubtitleLineFormat(int j, String odczyt) {
        System.out.println("Złe wartości opóznienia/klatek. Błąd w lini nr: "+j+",czyli \""+odczyt+"\"");
    }
}
