package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/22 15:01
 **/
public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0, 1}));
    }

    public static int missingNumber(int[] nums) {
        int n = nums.length + 1;
        System.out.println(n);
        int realSum = n * (n - 1) / 2;
        System.out.println(realSum);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        System.out.println(sum);
        return realSum - sum;
    }
}
