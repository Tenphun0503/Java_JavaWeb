package myjava.basic.multithreading.creation2;

/*
 * 使用Runnable接口创建多线程：
 * 编写一个程序，创建三个线程，分别输出"Hello"、"World"和"!"，要求线程之间按顺序执行，输出结果为"Hello World!"。
 */
public class MyRunnable {
    private static class MyR implements Runnable{
        @Override
        public void run(){
            System.out.println("Hello");
        }
    }
    private static class MyR2 implements Runnable{
        @Override
        public void run(){
            System.out.println("World");
        }
    }
    private static class MyR3 implements Runnable{
        @Override
        public void run(){
            System.out.println("!");
        }
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new MyR());
        th1.start();
        Thread th2= new Thread(new MyR2());
        th2.start();
        Thread th3= new Thread(new MyR3());
        th3.start();
    }
}
