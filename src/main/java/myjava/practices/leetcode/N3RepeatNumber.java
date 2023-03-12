/*
 * In a number array of n numbers range from (0, n-1), some number repeats.
 * Find one of them.
 * Find nothing return -1.
 *
 * Advance: Time complexity O(N), space complexity O(1).
 */
package myjava.practices.leetcode;
import java.util.HashMap;

public class N3RepeatNumber {
    public int findNumber1(int[] numbers) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int number : numbers){
            if(hm.containsKey(number)){
                return number;
            }
            else{
                hm.put(number, 1);
            }
        }
        return -1;
    }

    private void swap(int[] numbers, int i, int j) {
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

    // elements are in the range [0, n-1], the element with the value i can be adjusted to the i-th position.
    // if there is already an element with the value i at the i-th position, then the i value is repeated
    // O(1) on space
    public int findNumber2(int[] numbers) {
        int i = 0;
        while (i < numbers.length){
            while (numbers[i] != i){
                if (numbers[numbers[i]] == numbers[i]){
                    return numbers[i];
                }
                swap(numbers, i, numbers[i]);
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        N3RepeatNumber obj = new N3RepeatNumber();
        int[] input = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(obj.findNumber1(input));
        System.out.println(obj.findNumber2(input));
    }
}
