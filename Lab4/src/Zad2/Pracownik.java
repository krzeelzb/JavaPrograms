package Zad2;

import pesel.Pesel;

public abstract class Pracownik {
    double wynagrodzenieBrutto;
    Pesel pesel;

    public Pracownik() {
    }

    public Pracownik(Pesel pesel) {
        this.pesel = pesel;
    }

    public Pesel getPesel() {
        return pesel;
    }

    public double getWynagrodzenieBrutto() {
        return wynagrodzenieBrutto;
    }

    public double WynagrodzenieNetto() {
        return 0;
    }

}
