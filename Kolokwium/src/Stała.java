import java.util.Stack;

public class Stała extends Operator0Arg {
    public Stała(String wartość) {
        super(wartość);
    }

    @Override
    public double oblicz(Stack<Operator> s) {
        return Double.parseDouble(this.getWartość());
    }
}
