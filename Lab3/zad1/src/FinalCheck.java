import java.util.LinkedList;

public class FinalCheck {
    final double _var=3;

    public double changeVar( final double var ){
       // return var+=1; nie można tak zrobić bo jest to zmienna typu final, czyli niezmienna
        return 0;
    }
    public LinkedList<Double> changeList(final  LinkedList<Double> list){

        list.push(2.0);
        list.push(3.0);
        list.add(0,3.0);
        return list;
    }
}
