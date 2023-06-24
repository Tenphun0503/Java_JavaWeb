package myjava.basic.multithreading.task1.pc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {
    private final Object lock = new Object();
    private final List<Integer> numbers = new ArrayList<>();
    private final Random random = new Random();


    public void produce() throws InterruptedException {
        synchronized (lock) {
            for (int i = 1; i <= 100; i++){
                int size = 3;
                while (numbers.size() == size) {
                    lock.wait();
                }
                // generate new random number and put it into the list
                Thread.sleep(500);
                int number = random.nextInt(100);
                numbers.add(number);
                System.out.println("Producer produced number: " + number + " | " + numbers);
                // list is not empty, wake consumer up
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            for (int i = 1; i <= 100; i++){
                while (numbers.isEmpty()){
                    lock.wait();
                }
                // consume a number
                Thread.sleep(500);
                int number = numbers.remove(0);
                System.out.println("Consumer takes number: " + number + " | " + numbers);
                // list is not full, wake producer up
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        Thread t1 = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t2.start();
    }
}
