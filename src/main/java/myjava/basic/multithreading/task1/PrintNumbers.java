package myjava.basic.multithreading.task1;
/*
创建一个多线程程序，打印出数字1到10。
 */
public class PrintNumbers implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new PrintNumbers());
        t.start();
    }
}
