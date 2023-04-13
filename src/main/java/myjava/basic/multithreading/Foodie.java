package myjava.basic.multithreading;

public class Foodie extends Thread{
    public void run() {
        while (true){
            synchronized (Desk.lock){
                if (Desk.count==0){
                    break;
                }else{
                    if(Desk.foodFlag==0){
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.getStackTrace();
                        }
                    }else{
                        Desk.count--;
                        System.out.println("Foodie ate one, "+Desk.count+ " left.");
                        Desk.foodFlag=0;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
