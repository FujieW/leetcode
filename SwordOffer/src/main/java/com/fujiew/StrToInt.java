package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/11 10:45
 **/
public class StrToInt {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(strToInt("2147483648"));
    }

    public static int strToInt(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i = 0;
        int flag = 1; // 默认flag = 1， 正数
        int res = 0;
        while (i < str.length() &&str.charAt(i) == ' ') {
            i++;
        }
        if (i >= str.length()) {
            return 0;
        }
        if (str.charAt(i) == '-') {
            flag = -1;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+') { // 跳过符号位
            i++;
        }
        for (; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) { //溢出判定
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(i) - '0');
        }
        return flag * res;
    }
}
