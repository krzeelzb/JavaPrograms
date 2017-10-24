package Shape;

import java.util.LinkedList;

public abstract class Shape {
   public  LinkedList<Shape> list;
    public String name;
    public abstract void draw();
    public abstract void add();

}
