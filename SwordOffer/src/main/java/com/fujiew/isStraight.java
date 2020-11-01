package com.fujiew;

import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/30 17:21
 **/
public class isStraight {
    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{9, 10, 4, 0, 9}));
    }

    public static boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[joker] < 5;
    }
}
