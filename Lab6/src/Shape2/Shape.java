package Shape2;

import java.awt.*;

public abstract class Shape {
    public String name;
    public int wymiar;
    public int x;
    public int y;

    public Shape(int wymiar,int x,int y){
        this.x=x;
        this.y=y;
        this.wymiar=wymiar;

    }

    public abstract void draw(Graphics g, int x, int y);

    public abstract void setX(int x);
    public abstract void setY(int y);
    public abstract int getY();
    public abstract int getX();

}
