package myjava.basic.multithreading;

public class Cook extends Thread{

    @Override
    public void run() {
        while(true){
            synchronized (Desk.lock){
                if (Desk.count == 0) {
                    break;
                }else{
                    if(Desk.foodFlag==1){
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            e.getStackTrace();
                        }
                    }else{
                        System.out.println("Cooked a food");
                        Desk.foodFlag = 1;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }

    }

}
