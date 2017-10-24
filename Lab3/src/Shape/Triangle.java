package Shape;

public class Triangle extends Shape {

    @Override
    public void draw() {
        System.out.println("    .");
        System.out.println("   . .");
        System.out.println("  .   .");
        System.out.println(" .     .");
        System.out.println(".........");
    }
    @Override
    public void add(){
        list.add(this);
    };
}
