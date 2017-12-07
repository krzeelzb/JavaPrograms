package Shape2;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class MyPanel extends java.awt.Panel implements MouseMotionListener, MouseListener {
    public LinkedList<Shape> lista=new LinkedList<>();
    Shape toMove;
    MyPanel(){
        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(1000, 500));
    }
    void addShape(Shape shape){
        lista.add(shape);
    }


    @Override
    public void paint(Graphics g) {
        int x;
        int y;
        for(int i=0; i<lista.size(); i++){
            {
                x=lista.get(i).x;
                y=lista.get(i).y;
                lista.get(i).draw(g,x,y);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x1 = e.getX();
        int y1 = e.getY();

        int x2, y2;
        if (e.getButton() == MouseEvent.BUTTON1) {
            int clickCount = 0;
            int size = lista.size();
            Shape p;
            while (toMove == null && clickCount < size) {
                p = lista.get(clickCount);
                x2 = p.getX();
                y2 = p.getY();
                if (x1 >= x2 && y1 >= y2 && x1 <= x2+p.wymiar  && y1 <= y2+p.wymiar)
                    toMove = p;
                clickCount++;;
            }
        }

        repaint();
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if (toMove != null) {
            toMove.x = e.getX();
            toMove.y = e.getY();
        }
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        toMove = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }

    @Override
    public void mouseMoved(MouseEvent e) {


    }
//    public static MouseInputAdapter mouseHandler = new MouseInputAdapter(){
//        //internal JLabel displacement on mouse press for smooth dragging
//        public int labelDisX;
//        //internal JLabel displacement on mouse press for smooth dragging
//        public int labelDisY;
//        public void mousePressed(MouseEvent e) {
//            labelDisX = e.getX();
//            labelDisY = e.getY();
//            //move the card above all others
//            e.getComponent().getParent().setComponentZOrder(e.getComponent(), 0);
//            //repaint so card moves above others
//            e.getComponent().getParent().repaint();
//        }
//        public void mouseDragged (MouseEvent e) {
//            JPanel panel = (JPanel) e.getComponent().getParent();
//            //get preliminary new X coordinate
//            int newX = e.getComponent().getX() + e.getX() - labelDisX;
//            //get preliminary new Y coordinate
//            int newY = e.getComponent().getY() + e.getY() - labelDisY;
//            //here we check that the card is not
//            //being moved off the panel. If the
//            //user does try and do this then
//            //make the new coordinates such that
//            //the card is bounded by the panel's
//            //edges [extra credit]
//            if(newX > panel.getWidth() - CARD_WIDTH) {
//                newX = panel.getWidth() - CARD_WIDTH;
//            }
//            if(newY > panel.getHeight() - CARD_HEIGHT) {
//                newY = panel.getHeight() - CARD_HEIGHT;
//            }
//            if(newX < 0) { newX = 0; }
//            if(newY < 0) { newY = 0; }
//            e.getComponent().setLocation(newX, newY);
//        }
//    };
}

