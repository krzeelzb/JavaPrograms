import java.util.LinkedList;
import java.util.Scanner;
/**
 * Created by student on 2017-10-13.
 */
public class Test {
    public static void main(String[] argv){
        LinkedList<Punkt3D> punkty=new LinkedList<>();



        int _choice= 0;
        while(_choice<5)
        {
            System.out.println("1. Wczytaj punkt 3D\n" +
                    "2. Wyświetl wszystkie punkty\n" +
                    "3. Oblicz odległość\n" +
                    "4. Zakończ\n" +
                    "?");


            Scanner choice = new Scanner(System.in);
            _choice = choice.nextInt();

            if(_choice==4){
                break;
            }


            if(_choice==1){
                System.out.println(" Wczytaj punkt x");
                Scanner x = new Scanner(System.in);
                double _x = choice.nextInt();


                System.out.println(" Wczytaj punkt y");
                Scanner y = new Scanner(System.in);
                double _y = choice.nextInt();

                System.out.println(" Wczytaj punkt z");
                Scanner z = new Scanner(System.in);
                double _z = choice.nextInt();
                Punkt3D point=new Punkt3D(_x,_y,_z);
                punkty.push(point);

            }

            if(_choice==2){
                for (int i=0;i<punkty.size();i++){
                    Punkt3D point=punkty.get(i);
                    System.out.println("{"+point.getX()+","+point.getY()+"'"+point.getZ()+"}");
                }
            }

            if(_choice==3){
                for (int i=0;i<punkty.size();i++){
                    Punkt3D point=punkty.get(i);
                    double toreturn= point.distance(point);
                    System.out.println(toreturn);
                }
            }
        }

    }
}


