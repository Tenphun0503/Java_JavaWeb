package myjava.algorithm;

import java.util.Arrays;

public class Search {
    private Search() {
    }

    // Linear Search: Most basic searching method
    // Time Complexity: O(n)
    public static boolean linearSearch(int[] nums, int num) {
        for (int i : nums) {
            if (i == num) return true;
        }
        return false;
    }

    // Binary Search: nums list must be ordered
    // Time Complexity: O(logn) exclude sorting
    public static boolean binarySearch(int[] nums, int num) {
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == num) return true;
            else if (nums[mid] > num) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {131, 127, 147, 81, 103, 23, 7, 79};
        System.out.println(linearSearch(nums, 131));
        System.out.println(binarySearch(nums, 131));
    }
}
