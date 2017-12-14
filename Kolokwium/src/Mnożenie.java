import java.util.Stack;

public class Mnożenie extends Operator2Arg {
    public Mnożenie(String wartość) {
        super(wartość);
    }


    @Override
    public double oblicz(Stack<Operator> s) {
        return s.pop().oblicz(s)*s.pop().oblicz(s);
    }
}
