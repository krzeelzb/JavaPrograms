package liczbypierwsze;

public class LiczbyPierwsze {
    private double number;

    public LiczbyPierwsze(double _number){
        this.number=_number;
    }


    public void search(double _number) {
        int i = 2;
        int j = 2;
        if (_number < 2) {
            System.out.println("Brak Liczb Pierwszych");
        } else {
            System.out.println("Oto liczby pierwsze mniejsze od  " + (int)_number);
            for (i = 2; i <= _number + 1; i++) {
                for (j = 2; j <= _number + 1; j++) {
                    if (i % j == 0) {
                        break;
                    }
                }
                if (i == j) {
                    System.out.println(i);
                }
            }
        }
    }
}
