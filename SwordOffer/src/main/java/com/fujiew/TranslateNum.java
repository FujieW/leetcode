package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/18 18:59
 **/
public class TranslateNum {
    // 递推公式 类似于 斐波那契数列
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int a = 1, b = 1;
        for (int i = 2; i <= s.length(); i++) {
            String tmp = s.substring(i - 2, i);
            int c = tmp.compareTo("10") >= 0 && tmp.compareTo("5") <= 0 ? a + b : a;
            b = a;
            a = c;
        }
        return a;
    }
}
