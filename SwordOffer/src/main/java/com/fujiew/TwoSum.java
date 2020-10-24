package com.fujiew;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/23 17:29
 **/
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{10,26,30,31,47,60}, 40)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                return new int[]{nums[start], nums[end]};
            }
        }
        return new int[]{};
    }
}
