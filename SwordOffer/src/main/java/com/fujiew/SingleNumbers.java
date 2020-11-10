package com.fujiew;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/9 17:40
 **/
public class SingleNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumbers(new int[]{4, 1, 4, 6})));
    }

    public static int[] singleNumbers(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num ^= nums[i];
        }
        int a = 0;
        int b = 0;
        int res = 1;
        while ((num & res) == 0) {
            res <<= 1;
        }
        for (int n : nums) {
            if ((res & n) == 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }
}
