import java.util.Stack;

public class Dzielenie extends Operator2Arg {
    public Dzielenie(String wartość) {
        super(wartość);
    }

    @Override
    public double oblicz(Stack<Operator> s) {

        return  s.pop().oblicz(s)/(s.pop().oblicz(s));
    }
}
