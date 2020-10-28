package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/26 17:21
 **/
public class ReverseLeftWords {
    public static void main(String[] args) {
        System.out.println(reverseLeftWords("lrloseumgh", 10));

    }

    public static String reverseLeftWords(String s, int n) {
        if (n > s.length()) {
            return null;
        }
        StringBuilder str = new StringBuilder(s.length());
        for (int i = n; i < s.length(); i++) {
            str.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
