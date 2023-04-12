package myjava.practices;


import myjava.practices.basic.multithreading.MyRun;
import myjava.practices.basic.multithreading.MyThread;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyRun mr = new MyRun();
        Thread t1 = new Thread(mr);

        t1.start();


    }



}
