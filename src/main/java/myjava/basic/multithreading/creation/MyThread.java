package myjava.basic.multithreading.creation;

/*
 编写一个程序，创建两个线程，分别打印出 "Hello" 和 "World"，并确保它们交替打印
 */

public class MyThread{
    private static class ThreadOne extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello");
            }
        }
    }
    private static class ThreadTwo extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("World");
            }
        }
    }

    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();
        t1.start();
        t2.start();
    }
}
