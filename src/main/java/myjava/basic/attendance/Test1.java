package myjava.basic.attendance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        /*
            n students in the class
            students: name, age, gender
            realize a random attendance checker
         */

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Alice", "Bob", "Charlie", "Dave", "Eve", "Frank", "Grace", "Harry");
        // use random
        Random r = new Random();
        int index = r.nextInt(list.size());
        System.out.println(list.get(index));
        // use shuffle()
        Collections.shuffle(list);
        System.out.println(list.get(0));
    }
}
