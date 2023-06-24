package myjava.basic.multithreading.task1;

/*
编写一个程序，创建两个线程，一个线程打印1到50的奇数，另一个线程打印1到50的偶数
 */
public class PrintNumbers2 implements Runnable{
    int start;
    int end;

    public PrintNumbers2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for(int i = start; i <= end; i +=2){
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintNumbers2(1, 49));
        Thread t2 = new Thread(new PrintNumbers2(2, 50));
        t1.start();
        t2.start();
    }
}
