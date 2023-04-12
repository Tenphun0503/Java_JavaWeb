package myjava.practices;


import myjava.practices.basic.multithreading.MyRun;
import myjava.practices.basic.multithreading.MyThread;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Jack-15", "Jenny-18", "Rose-16", "John-19", "Lisa-20");

        Map<String, String> map = list.stream().collect(Collectors.toMap(
                s -> s.split("-")[0], s -> s.split("-")[1]));
    }
}
