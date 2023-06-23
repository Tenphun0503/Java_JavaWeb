package myjava.basic.multithreading.creation2;

/*
 * 使用Thread类创建多线程：
 * 编写一个程序，创建两个线程，分别输出数字1到10和字母A到J，要求数字和字母交替输出。
 */
public class MyThread {
    boolean isNum = true;
    final Object lock = new Object();

    public void printNumber() throws InterruptedException {
        synchronized (lock){
            for (int i = 1; i <= 10; i++) {
                while(!isNum){
                    lock.wait();
                }
                System.out.println(i);
                isNum = false;

                lock.notify();
            }
        }
    }
    public void printLetter() throws InterruptedException {
        synchronized (lock){
            for (int i = 'A'; i < 'K'; i ++){
                while(isNum){
                    lock.wait();
                }
                System.out.println((char) i);
                isNum = true;

                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        Thread t1 = new Thread(()-> {
            try {
                t.printLetter();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(()-> {
            try {
                t.printNumber();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}
