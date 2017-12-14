package zad4;



import java.util.LinkedList;

public class Kadry {
    LinkedList<Pracownik> kadra=new LinkedList<>();


    public void add(Pracownik toadd){
        kadra.add(toadd);
    }
    public void delete(Pracownik todelete){
        kadra.remove(kadra.indexOf(todelete));

    }

    public Pracownik search(Pesel pesel){
        for (Pracownik k:kadra){
            if(k.pesel==pesel){
                return k;
            }
        }
        return null ;



    }


}
