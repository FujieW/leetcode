package com.fujiew;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/10 10:58
 **/
public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{3, 5, 3, 3}));
    }


    public static int singleNumber(int[] nums) {
        int one = 0;
        int two = 0;
        for (int num : nums) {
            one = one ^ num & ~two;
            two = two ^ num & ~one;
        }
        return one;
    }

    /*public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int cnt = 0;
            for (int n : nums) {
                // n & 1 << i 的值大于0即为真
                if ((n & (1 << i)) > 0) {
                    cnt++;
                }
            }
            // 构造只出现一次的那个数字，采用异或的方法生成二进制中的每一位
            if (cnt % 3 == 1) {
                ans ^= (1 << i);
            }
        }
        return ans;
    }*/
}