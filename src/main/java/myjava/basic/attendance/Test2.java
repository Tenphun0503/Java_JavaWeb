package myjava.basic.attendance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        /*
            n students in the class
            students: name, age, gender
            realize a random attendance checker
            70% boys
            30% girls
         */

        ArrayList<String> boys = new ArrayList<>();
        Collections.addAll(boys, "Adam", "Bob", "Charlie", "Dave", "Edward", "Frank", "Harry");
        ArrayList<String> girls = new ArrayList<>();
        Collections.addAll(girls, "Alice", "Beth", "Catherine", "Diana", "Emily", "Fiona");

        ArrayList<Integer> random = new ArrayList<>();
        Collections.addAll(random, 1,1,1,1,1,1,1,0,0,0);
        System.out.println(random.size());

        Collections.shuffle(random);
        if(random.get(0)==1){
            Collections.shuffle(boys);
            System.out.println(boys.get(0));
        }else{
            Collections.shuffle(girls);
            System.out.println(girls.get(0));
        }


    }
}
