# Multithreading

---
### _[1. Intro](#Intro)_
### _[2. Implementation](#Implementation)_
### _[3. CommonMethods](#CommonMethods)_
### _[4. Thread Safety](#ThreadSafety)_


---
## Intro
### Multithreading
Manage multiple threads of execution simultaneously within a single process
### Process
A process is an instance of a running program. 
### Concurrency
Multiple tasks concurrently executed on a cpu
### Parallelism
Multiple tasks parallel executed on multiple cpus
### Schedule threads
Preemptive scheduling: The scheduler interrupts the currently running thread and switches to a higher-priority thread, based on a predefined priority scheme.
### Daemon
In Java, a daemon thread is a type of thread that runs in the background, providing a service or support function for other threads or the application as a whole.
It starts ending when other thread ends.
### lifecycle
1. thread created (state:`NEW`)
2. thread ready (state:`RUNNABLE`): `start()`, snatch cpu
3. thread running (state: `RUNNING`): operating system gives the thread CPU time, thread is executing code
4. thread end (state: `TERMINATED`):  thread completes its work
- 2 and 3 may change to each other because of losing of CPU time.
- At some point, thread trys to acquire a lock that is already held by another thread, it will be blocked (state: `BLOCKED`)
- At some point, thread waiting because of `wait()`, it can't execute nor snatch cpu. (state: `WAITING`) And will wait for a `notify()`
- At some point, thread waiting for some time because of `sleep()` (state: `TIMED WAITING`)
### DeadLock
Two or more threads are blocked, waiting for each other to release a lock or resource that they hold.

---
## Implementation
### Thread
- poor scalability
- Define a class extends from `Thread`, and override `run()`
```java
class MyThread extends Thread{
    @Override
    public void run(){}
}
```
- Then instantiate the class and use `start()` start the thread
```java
class Example{
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.strat();
    }
}
```

### Runnable
- Define a class implements `Runnable`, and override `run()`
```java
class MyRun implements Runnable{
    @Override
    public void run(){}
}
```
- Then create a `Thread` object and pass its constructor a `MyRun` instance
```java
class Example{
    public static void main(String[] args) {
        MyRun mr = new MyRun();
        Thread t = new Thread(mr);
        t.start();
    }
}
```

### Callable and Future
- previous `run()` return nothing, but this way returns
- Define a class implements `Callable`, and override `call()`
```java
class MyCallable implements Callable<Integer>{
    @Override
    public Integer call() throws Exception{
        int sum = 0;
        // e.g. compute sum of 1-100
        return sum;
    }
}
```
- Create `MyCallable` object, `FutureTask` object (implements `Future`) and Thread object
```java
class Example{
    public static void main(String[] args) {
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(mc);
        Thread t = new Thread(ft);
        t.start();
        Integer result = ft.get();
    }
    
}
```

---
## CommonMethods
- `String getName()`: Thread has default name "Thread-x" (x is 0-indexed)
- `void setName(String name)`
- `static Thread currentThread()`: get current Thread object
- `static void sleep(long time)`: sleep a thread for a time
- `setPriority(int newPriority)`: 5 by default, can be 1-10
- `final int GetPriority()`
- `final void setDaemon(boolean on)`
- `public static void yield()`: allows a thread to voluntarily give up the CPU and allow other threads to run
- `public static void join()`: allows other thread waits until the calling thread complete execution
- `void wait()` wait until notified by other thread
- `void notify()` randomly notify one thread
- `void notifyAll()`

---
## ThreadSafety
### Synchronization
- Synchronization is a technique used to ensure that only one thread at a time can access a shared resource.
- Put the code block that sharing resource in `synchronized(lock){}`
- `lock` serve as the lock for the block, must be unique and shared e.g. `private static final Object lock = new Object();`
### Synchronized method
- use `synchronized` modify a methods e.g. `synchronized void method()`
### Lock (from JDK5)
- `class ReenterantLock implements Lock`
- `static Lock lock = new ReenterantLock();`
- `void lock()`
- `void unlock()`: use `try/catch` to include all code and put `unlock()` in the `finally{}`

---
## Producer and Consumer
### [Cook](../src/main/java/myjava/basic/multithreading/Cook.java) and [Foodie](../src/main/java/myjava/basic/multithreading/Foodie.java)
### blockingQueue
- Collection - Queue - BlockingQueue - ArrayBlockingQueue/LinkedBlockingQueue
- ArrayBlockingQueue: bounded
- LinkedBlockingQueue: unbounded  

---
## Thread pool
### Use Executors:
- `public static ExecutorService newCachedThreadPool()` Create a no limit pool
- `public static ExecutorService newFixedThreadPool(int nThreads)` 
### Self Defined (7 keys)
- Core Thread number
- Max Thread number
- free thread maximum lifetime
- free thread maximum time unit
- task queue
- thread factory
- task 