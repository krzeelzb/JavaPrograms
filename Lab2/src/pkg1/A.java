package pkg1;

import java.util.Scanner;

public class A {
    int number;
    String name;

    public A(int number, String name) {
        this.number = number;
        this.name = name;
    }


    public void callDecrement() {
        number -= 1;
    }

    public void callChangeName() {
        Scanner klawiatura = new Scanner(System.in);
        String a = klawiatura.next();
        name = a;

    }

    public void callIncrement() {
        number += 1;
    }

    private void increment() {
        number += 1;
    }

    protected void decrement() {
        number -= 1;
    }

    void changeName() {
        name = "kot";
    }
}