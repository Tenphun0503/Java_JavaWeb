package myjava.basic.multithreading.creation;

/*
 编写一个程序，使用实现了 Runnable 接口的类，创建三个线程，分别打印出 "Good", "Better" 和 "Best"，并确保它们按顺序打印。
 */
public class MyRunnable {
    private static class RunnableOne implements Runnable {
        @Override
        public void run() {
            System.out.println("Good");
        }
    }
    private static class RunnableTwo implements Runnable {
        @Override
        public void run() {
            System.out.println("Better");
        }
    }
    private static class RunnableThree implements Runnable {
        @Override
        public void run() {
            System.out.println("Best");
        }
    }

    public static void main(String[] args) {
        Runnable r1 = new RunnableOne();
        Runnable r2 = new RunnableTwo();
        Runnable r3 = new RunnableThree();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        t1.start();
        t2.start();
        t3.start();
    }
}
