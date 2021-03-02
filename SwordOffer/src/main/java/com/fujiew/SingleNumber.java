package com.fujiew;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/10 10:58
 **/
public class SingleNumber {
    public static void main(String[] args) {
        // System.out.println(singleNumber(new int[]{3, 5, 3, 3}));
        String str = "{{[(ASD)SD{SD}]";
        System.out.println(isCorrect(str));
    }

    public static boolean isCorrect(String str) {
        char[] chars = str.toCharArray();
        LinkedList<Character> stack = new LinkedList();
        for(int i =0; i<chars.length;i++){
            if(chars[i] == '[' || chars[i]== '{' || chars[i] == '('){
                stack.addLast(chars[i]);
            } else{
                // 数字，字母
                if (chars[i] != ']' && chars[i]!= '}' && chars[i] != ')'){
                    continue;
                } else{
                    if (stack.isEmpty()) {
                        return false;
                    }
                    // 是右括号
                    if (chars[i] == ']'){
                        if(stack.getLast() == '['){
                            stack.removeLast();
                        }else{
                            return false;
                        }
                    } else if(chars[i] == '}'){
                        if(stack.getLast() == '{'){
                            stack.removeLast();
                        }else{
                            return false;
                        }
                    } else{
                        if(stack.getLast() == '('){
                            stack.removeLast();
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        return stack.isEmpty();
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

    public static int singleNumber2(int[] nums) {
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
    }

    public static int singleNumber3(int[] nums) {
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                count[j] += nums[i] & 1;
                nums[i] >>>= 1;
            }
        }
        int res = 0;
        int m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res = res | (count[31 - i] % m);
        }
        return res;
    }
}
