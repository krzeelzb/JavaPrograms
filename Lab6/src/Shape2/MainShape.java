package Shape2;
//po2017
//SmieszneHaslo


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainShape extends java.awt.Frame{
    public static final int CARD_HEIGHT = 1000;
    public static final int CARD_WIDTH = 1000;

    public MainShape() {
        super("Kształty");
    }

    public static void main(String[] argv)  {

        Shape kolo=new Circle(300,500,500);
        Shape trojkat=new Triangle(300,300,100);
        Shape kwadrat=new Square(100,100,100);

        MainShape sp=new MainShape();
        MyPanel mp= new MyPanel();

        mp.addShape(kolo);
        mp.addShape(trojkat);
        mp.addShape(kwadrat);

        sp.setSize(CARD_HEIGHT,CARD_WIDTH);
        sp.setVisible(true);
        sp.add(mp);

        sp.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
        ;
        ;
//        Square sq = new Square();
//        sq.name="a";
//        LinkedList<Shape> list = new LinkedList<Shape>();
//        Square sq2 = new Square();
//        sq2.name="aaaddd";
//        list.add(sq);
//        list.add(sq2);
//        Circle cir = new Circle();
//        cir.name="bbb";
//        list.add(cir);

//        DrawerProgram dp = new DrawerProgram();
//        Circle d= new Circle(100);
//        d.draw(d,100,100);
//        dp.setSize(450, 450);
//        dp.setVisible(true);
//        dp.add(d);
//        dp.addWindowListener(new WindowAdapter(){
//            public void windowClosing(WindowEvent we){
//                System.exit(0);
//            }
//        });
//
//
//        DrawerProgram dp2 = new DrawerProgram();
//        Square d2= new Square(100);
//        dp2.setSize(450, 450);
//        dp2.setVisible(true);
//        dp2.add(d2);
//        dp2.addWindowListener(new WindowAdapter(){
//            public void windowClosing(WindowEvent we){
//                System.exit(0);
//            }
//        });
//
//        DrawerProgram dp3 = new DrawerProgram();
//        Triangle d3= new Triangle(100);
//        dp3.setSize(450, 450);
//        dp3.setVisible(true);
//        dp3.add(d3);
//        dp3.addWindowListener(new WindowAdapter(){
//            public void windowClosing(WindowEvent we){
//                System.exit(0);
//            }
//        });


//        for (Shape n : list) {
//            //n.draw();
//        }
//
//        Collections.sort(list, new Comparator<Shape>() {
//                    @Override
//                    public int compare(Shape o1, Shape o2) {
//                        if (o1.name.charAt(0) > o2.name.charAt(0)) {
//                            return -1;
//
//                        }
//                        if (o1.name.charAt(0) < o2.name.charAt(0)) {
//                            return 1;
//
//                        } else
//                            return 0;
//                    }
//                }
//        );
//        for (Shape n : list) {
//           // n.draw();
//        }
    }
}



