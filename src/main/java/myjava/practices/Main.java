package myjava.practices;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    private int round = 0;

    public void fun(){
        if(round==5)return;
        System.out.println(round++);

        System.out.println("a");
        this.fun();
        System.out.println("b");
        System.out.println("c");
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[] nums = {2,3,4,5};
        int[] nums2 = nums;
        nums2[0] = 1;
        System.out.println(Arrays.toString(nums));
    }
}