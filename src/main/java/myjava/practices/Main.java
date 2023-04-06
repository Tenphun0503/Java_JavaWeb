package myjava.practices;

import java.util.Arrays;

public class Main {
    private static int method(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        while(nums[i]<0 && k>0 && i<nums.length-1){
            nums[i] = -nums[i];
            k--;
            i++;
        }
        Arrays.sort(nums);
        int res = k%2==0 ? nums[0] : -nums[0];
        for (int j = 1; j < nums.length; j++) {
            res += nums[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] nums = {-4,-2,-3};
        System.out.println(method(nums, k));
    }
}