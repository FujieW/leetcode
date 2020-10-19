package com.fujiew;

import java.util.HashMap;

/**
 * 剑指Offer 03， 数组中重复的元素
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/19 21:06
 *
 **/
public class FindRepeatNumber {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber2(new int[]{2, 3, 1, 0, 4, 5, 3}));
    }

    // 遍历数组，将数组加进 hashmap 里面， hashmap 查询的时间复杂度是 O(1)
    public static int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                return num;
            }
        }
        return 0;
    }

    // 最优解， 将位置0放0， 位置1放1，
    public static int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i] == nums[nums[i]]) {
                // 这里第一次想到的是，当nums[i] < i 是也可以返回，不过是错误的，
                // 当数据是 1,1,1 的时候会死循环
                return nums[i];
            }
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i]= temp;
        }
        return 0;
    }
}
