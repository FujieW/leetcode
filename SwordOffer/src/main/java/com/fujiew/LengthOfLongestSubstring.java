package com.fujiew;

import java.util.HashMap;

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
        int i = -1, max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            max = Math.max(max, j - i);
        }
        return max;
    }
}
