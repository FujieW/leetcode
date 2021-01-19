package com.fujiew;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 剑指Offer 03， 数组中重复的元素
 *
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/19 21:06
 **/
public class FindRepeatNumber {
    public static void main(String[] args) {
        System.out.println(findRepeatNumber2(new int[]{2, 3, 1, 0, 2, 5, 3}));
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

    // 最优解， 数组下标为i的地方放置数字i
    public static int findRepeatNumber2(int[] nums) {
        int i = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
            } else {
                int index = nums[i];
                // 输出从左向右第一个重复的数字
                if (index == nums[index]) {
                    return index;
                }
                // 输出全部的重复数字
                /*if (index == nums[index]) {
                    list.add(index);
                    i++;
                    continue;
                }*/
                nums[i] = nums[index];
                nums[index] = index;
            }
        }
        System.out.println(list);

        return 0;
    }


}
