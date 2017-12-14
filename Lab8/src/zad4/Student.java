package zad4;



public class Student extends Pracownik {
    public Student(Pesel pesel) {
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

