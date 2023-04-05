package myjava.practices;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] res = new int[nums.length];
        int index = 0;
        while(left<right){
            if(Math.abs(nums[left])>=Math.abs(nums[right])){
                res[index] = nums[left] * nums[left];
                left++;
            }else{
                res[index] = nums[right] * nums[right];
                right--;
            }
            index ++;
        }
        left = 0;
        right = nums.length-1;
        while(left<right){
            res[left] = res[left] ^ res[right];
            res[right] = res[left] ^ res[right];
            res[left] = res[left] ^ res[right];
            right--;
            left++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }
}