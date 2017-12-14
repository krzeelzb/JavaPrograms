package zad4;



public abstract class Pracownik {
    double wynagrodzenieBrutto;
    double wynagrodzenieNetto;
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
        return wynagrodzenieNetto;
    }

}
