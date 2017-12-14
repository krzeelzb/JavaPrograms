import java.util.Stack;

public class Dodawanie extends Operator2Arg {
    public Dodawanie(String wartość) {
        super(wartość);
    }

    @Override
    public double oblicz(Stack<Operator> s) {

         return s.pop().oblicz(s)+s.pop().oblicz(s);
    }
}
