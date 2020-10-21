package com.fujiew;

import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/21 15:17
 **/
public class Exchange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 3, 4})));
    }

    public static int[] exchange(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            // 奇数情况下移动，目的：从左到右找第一个偶数
            while (low < high && (nums[low] & 1) == 1) {
                low++;
            }
            // 偶数情况下移动，目的：从右到左找第一个奇数
            while (low < high && (nums[high] & 1) == 0) {
                high--;
            }
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }
        return nums;
    }
}
