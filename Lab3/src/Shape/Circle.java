package Shape;

public class Circle extends Shape{

        @Override
        public void draw() {
            System.out.println("   ..   ");
            System.out.println("  .  .");
            System.out.println(" .    .");
            System.out.println(".      .");
            System.out.println(" .    .");
            System.out.println("  .  .");
            System.out.println("   ..");
        }

    public void add(){
            list.add(this);
    };


}