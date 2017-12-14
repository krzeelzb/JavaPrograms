public abstract class Operator implements Obliczenie{

    public String wartość;

    public Operator(String wartość) {
        this.wartość = wartość;
    }

    public Operator() {

    }

    public String getWartość() {
        return wartość;
    }
}
