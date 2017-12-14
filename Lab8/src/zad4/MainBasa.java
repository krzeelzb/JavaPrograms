package zad4;

public class MainBasa {
    public static void main(String[] args){
    Baza b=new Baza();
    if(b.connect()==true){
        b.listNames("11111111111");
        b.insertWorker("111111111111","student",3000,2700);
    }
    }
}
