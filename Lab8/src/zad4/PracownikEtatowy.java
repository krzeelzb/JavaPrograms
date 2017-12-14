package zad4;



import java.sql.DriverManager;
import java.sql.SQLException;

public class PracownikEtatowy extends Pracownik {
    public PracownikEtatowy(Pesel pesel) {
        super(pesel);
    }

    @Override
    public double WynagrodzenieNetto() {
        return super.WynagrodzenieNetto();
    }

    @Override
    public double getWynagrodzenieBrutto() {
        return super.getWynagrodzenieBrutto();
    }

    @Override
    public Pesel getPesel() {
        return super.getPesel();
    }
}


