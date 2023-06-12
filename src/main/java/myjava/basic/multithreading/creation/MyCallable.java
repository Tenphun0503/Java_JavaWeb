package myjava.basic.multithreading.creation;

import java.util.concurrent.*;

/*
 编写一个程序，创建一个实现了 Callable 接口的类，计算给定数组中所有元素的总和，并返回结果。使用 Future 获取计算结果并打印出来
 */
public class MyCallable implements Callable<Integer> {
    Integer[] nums;
    public MyCallable(Integer[] nums){
        this.nums = nums;
    }
    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for (Integer num : nums) {
            sum += num;
        }
        return sum;
    }
}
class Test{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Integer[] nums = {1,2,3,4,5,6,7,8,9};
        ExecutorService es = Executors.newSingleThreadExecutor();
        Future<Integer> future = es.submit(new MyCallable(nums));
        System.out.println(future.get());
        es.shutdown();
    }
}
