package io;

import java.util.*;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/11 22:14
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] nums = s.split(" ");
            if (nums.length < 2) {
                continue;
            }
            long a = Long.parseLong(nums[0]);
            long b = Long.parseLong(nums[1]);
            System.out.println(a + b);
        }
    }
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                if (nums[i + 1] != nums[i]) {
                    return nums[i];
                }
            } else if (i == nums.length - 1) {
                if (nums[i - 1] != nums[i]) {
                    return nums[i];
                }
            } else {
                if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }
}
