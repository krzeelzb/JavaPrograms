package Drawer;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import static java.lang.StrictMath.sqrt;

public class Drawer extends JPanel {

    public  void drawCircle(Graphics arg0, int x, int y, int r){
        Graphics2D g2 = (Graphics2D) arg0;
        Ellipse2D e = new Ellipse2D.Double(x,y,r,r);
        g2.draw(e);
        GradientPaint gp = new GradientPaint(x-r/2, y-r/2, Color.red,x+r/2, y+r/2, Color.blue, false);
        g2.setPaint(gp);
        g2.fill(e);
        g2.draw(e);

    }

    private  void drawString(Graphics arg0, int x, int y, String s){
        Graphics g = arg0;
        g.setColor(Color.red);

        g.setFont(new Font("SansSerif",Font.BOLD,30));
        g.drawString(s, x, y);

    }

    public void drawRect(Graphics arg0,int x, int y, int w, int h){
        Graphics2D g2 =(Graphics2D) arg0;
        Rectangle2D e=new Rectangle2D.Double(x,y, w,h);
        g2.setColor(Color.red);
        g2.fill(e);
        g2.draw(e);

    }


    public void drawTriang(Graphics g, int x, int y, int w) {
        int a=(int)(x+w);
        int b=(int)(x+w/2);
        int height=(int)(w*sqrt(3)/2);
        int c=(int)(y+w);
        Graphics g2 = g;


        g2.setColor(Color.orange);
        g2.fillPolygon(new int[]{x,b,a}, new int[]{c,c-(int)w,c}, 3 );
        g2.drawPolygon(new int[]{x,b,a}, new int[]{c,c-(int)w,c}, 3 );
}

//    @Override
//    public void paint(Graphics arg0) {
//        drawRect(arg0,100,100,200,200);
//        drawCircle(arg0,100, 100, 200);
//        drawString(arg0,200, 200, "A");
//
//    }





}