package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/21 22:04
 **/
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    public static int majorityElement(int[] nums) {
        int x = 0;
        int votes = 0;
        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
            votes += x == num ? 1 : -1;
        }
        int count = 0;
        for (int num : nums) {
            if (num == x) {
                count++;
            }
        }
        return count > nums.length / 2 ? x : 0;
    }
}
