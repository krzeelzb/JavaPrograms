package Shape;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class MainShape {
    public static void main(String[] argv) {
        Square sq = new Square();
        sq.draw();
        sq.name="a";
        LinkedList<Shape> list = new LinkedList<Shape>();
        Square sq2 = new Square();
        sq2.name="aaaddd";
        list.add(sq);
        list.add(sq2);
        Circle cir = new Circle();
        cir.name="bbb";
        list.add(cir);





        for (Shape n : list) {
            n.draw();
        }

        Collections.sort(list, new Comparator<Shape>() {
                    @Override
                    public int compare(Shape o1, Shape o2) {
                        if (o1.name.charAt(0) > o2.name.charAt(0)) {
                            return -1;

                        }
                        if (o1.name.charAt(0) < o2.name.charAt(0)) {
                            return 1;

                        } else
                            return 0;
                    }
                }
        );
        for (Shape n : list) {
            n.draw();
        }
    }
}



