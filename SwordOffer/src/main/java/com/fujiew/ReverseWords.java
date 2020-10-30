package com.fujiew;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/30 14:14
 **/
public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));

    }

    public static String reverseWords(String s) {
        int i = s.length() - 1;
        int j = i;
        StringBuilder str = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            str.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return str.toString().trim();
    }
}
