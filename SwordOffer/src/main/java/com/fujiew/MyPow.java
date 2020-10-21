package com.fujiew;


/**
 * 剑指 Offer 16. 数值的整数次方
 *
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/21 08:47
 * 2.00000
 * -2147483648
 **/
public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2, -2147483648));
        System.out.println(Math.pow(2, -2147483648));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (x == 0) {
            return 0;
        }
        boolean flag = n < 0;
        n = n < 0 ? -n : n;
        double result = myPow(x, n >> 1);
        result *= result;
        if ((n & 0x1) == 1) {
            result *= x;
        }
        if (flag) {
            return Double.isInfinite(1 / result) ? 0 : 1 / result;
        } else {
            return result;
        }
    }
}
