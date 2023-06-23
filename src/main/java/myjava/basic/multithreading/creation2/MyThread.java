package myjava.basic.multithreading.creation2;

/*
 * 使用Thread类创建多线程：
 * 编写一个程序，创建两个线程，分别输出数字1到10和字母A到J，要求数字和字母交替输出。
 */
public class MyThread {
    private static class ThreadOne extends Thread {
        @Override
        public void run(){
            for (int i = 1; i <= 10; i++) {
                System.out.println(i);
            }
        }
    }

    private static class ThreadTwo extends Thread {
        @Override
        public void run(){
            for (int i = 'A'; i < 'K'; i ++){
                System.out.println((char) i);
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
