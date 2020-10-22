package com.fujiew;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/21 22:49
 **/
public class FirstUniqChar {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

    public static char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()){

                return entry.getKey();
            }
        }
        return ' ';
    }
}
