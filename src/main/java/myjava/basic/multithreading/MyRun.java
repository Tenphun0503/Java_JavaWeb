package myjava.basic.multithreading;

public class MyRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello World");
        }
    }
}
