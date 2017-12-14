import java.util.Stack;

public class Silnia extends Operator1Arg{


    public Silnia(String wartość) {
        super(wartość);
    }

    @Override
    public double oblicz(Stack<Operator> s) {
        return 0;
    }
    //return s.pop().oblicz(s)*s.pop().oblicz(s);
    public int fact(int i){
        if (i < 1)
            return 1;
        else
            return i * fact(i - 1);
    }
}
