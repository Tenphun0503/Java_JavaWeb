package myjava.basic.map;

import java.util.*;

public class StateAndCity {
    public static void main(String[] args) {
        /* Use a map, key is state, value is city, value can be multiple*/
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> city1 = new ArrayList<>();
        Collections.addAll(city1, "Los Angeles", "San Francisco", "San Diego");
        map.put("California", city1);
        ArrayList<String> city2 = new ArrayList<>();
        Collections.addAll(city2, "New York City", "Buffalo", "Rochester");
        map.put("New York", city2);
        ArrayList<String> city3 = new ArrayList<>();
        Collections.addAll(city3, "Houston", "Austin", "Dallas", "San Antonio");
        map.put("Texas", city3);


        map.forEach((k, v)->{
            StringBuilder sb = new StringBuilder();
            sb.append(k).append(" = ");
            StringJoiner sj = new StringJoiner(", ", "", "");
            v.forEach(sj::add);
            sb.append(sj);
            System.out.println(sb);
        });


    }
}
