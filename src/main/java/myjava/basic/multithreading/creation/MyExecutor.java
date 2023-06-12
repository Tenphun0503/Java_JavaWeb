package myjava.basic.multithreading.creation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 编写一个程序，使用 ExecutorService 创建一个固定大小为 3 的线程池，然后提交 5 个任务给线程池执行，每个任务打印出当前线程的名称
 */
public class MyExecutor {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            es.submit(() -> System.out.println(Thread.currentThread().getName()));
        }
        es.shutdown();
    }
}
