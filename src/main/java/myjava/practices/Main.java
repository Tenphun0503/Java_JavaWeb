package myjava.practices;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Ssss");

        Iterator<String> it = list.iterator();
        System.out.println(it.next());
    }

}
