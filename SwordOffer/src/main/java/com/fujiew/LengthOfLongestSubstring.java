package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/9 17:06
 **/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("hello world"));
        System.out.println(2 ^ 10);

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = 1;
        int maxLength = 0;
        while (j < chars.length - 1) {
            if (chars[i] != chars[j]) {
                j++;
            } else {
                maxLength = Math.max(j - i, maxLength);
                i++;
            }
        }
        return maxLength;
    }
}
