package myjava.basic;

import java.util.Arrays;
import java.util.HashMap;

public class Test1 {
    public static void main(String[] args) {
        int[] input = {1, 3, 2, -1, 0, -1, 3}; //output: [1, 2, 0]
        System.out.println(Arrays.toString(removeDup(input)));
    }

    public static int[] removeDup(int[] input) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: input){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int i = 0;
        for(int k: map.keySet()){
            if(map.get(k)==1){
                i++;
            }
        }
        int[] res = new int[i];
        i = 0;
        for(int k: map.keySet()){
            if(map.get(k)==1) res[i++]=k;
        }
        return res;
    }
}
