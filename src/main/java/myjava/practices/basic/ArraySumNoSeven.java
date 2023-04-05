package myjava.practices.basic;

public class ArraySumNoSeven {
    public static void main(String[] args) {
        int[] nums = {68,27,95,88,171,996,51,210};
        System.out.println(getSum(nums));
    }

    private static int getSum(int[] nums) {
        int res = 0;
        for(int num : nums){
            if(num%2==1)continue;
            else if(num%10==7 || num/10%10==7)continue;
            else res+=num;
        }
        return res;
    }
}
