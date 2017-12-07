package Drawer;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class DrawerProgram extends JFrame {

    public static void main(String [] argv){
        DrawerProgram dp = new DrawerProgram();
        Drawer d = new Drawer();
        dp.setSize(450, 450);
        dp.setVisible(true);
        dp.add(d);

        dp.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
        ;

    }



}