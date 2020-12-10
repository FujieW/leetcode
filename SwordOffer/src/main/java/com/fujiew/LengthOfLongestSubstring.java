package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/9 17:06
 **/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("a"));
        System.out.println(lengthOfLongestSubstring("aaaa"));
        System.out.println(lengthOfLongestSubstring("abbbaa"));
        System.out.println(lengthOfLongestSubstring(""));

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int i = 0;
        int j = i + 1;
        int maxLength = 0;
        while (i < chars.length && j < chars.length) {
            if (chars[i] != chars[j]) {
                j++;
            } else {
                maxLength = Math.max(maxLength, j - i);
                i++;
            }
        }
        return maxLength;
    }
}
