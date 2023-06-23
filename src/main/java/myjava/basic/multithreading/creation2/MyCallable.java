package myjava.basic.multithreading.creation2;

import java.util.concurrent.*;

/*
 * 使用Callable和Future创建多线程：
 * 编写一个程序，创建两个线程，分别计算斐波那契数列的第N项和第N+1项，然后输出这两个结果的和。
 */

public class MyCallable implements Callable<Integer> {
    private Integer n;

    public MyCallable(Integer n){
        this.n = n;
    }
    private Integer fun(Integer n){
        if(n==1) return 0;
        if(n==2) return 1;
        else return fun(n-1) + fun(n-2);
    }
    @Override
    public Integer call(){
        return fun(n);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> n = es.submit(new MyCallable(3));
        Future<Integer> nPlusOne = es.submit(new MyCallable(4));
        System.out.println(n.get() + nPlusOne.get());
        es.shutdown();
    }
}
