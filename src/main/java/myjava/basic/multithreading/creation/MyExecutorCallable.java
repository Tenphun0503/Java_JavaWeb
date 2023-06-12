package myjava.basic.multithreading.creation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 编写一个程序，使用 ExecutorService 创建一个线程池，然后提交 5 个实现了 Callable 接口的任务给线程池执行，
 每个任务返回当前线程的名称，并使用 Future 获取执行结果并打印出来
 */
public class MyExecutorCallable {
    public static void main(String[] args) throws Exception{
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            Future<String> future = es.submit(new Callable<String>() {
                @Override
                public String call(){
                    return Thread.currentThread().getName();
                }
            });
            System.out.println(future.get());
        }
        es.shutdown();
    }
}
