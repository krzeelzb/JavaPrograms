package pkg1;



public class B extends A {
    protected void decrement(){
        number-=2;
    }

    //@Override
    //void changeName();


    private void increment(){
        number+=2;
    }

    public B(int number, String name) {
        super(number, name);
    }


}