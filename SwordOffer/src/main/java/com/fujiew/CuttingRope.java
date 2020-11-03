package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/3 14:21
 **/
public class CuttingRope {
    public static void main(String[] args) {
        System.out.println(cuttingRope(127));
    }

    public static int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        long res = 1;
        while (n > 4) {
            n = n - 3;           //尽可能地多剪长度为3的绳子
            res = res * 3;
            res %= 1000000007;
        }
        return (int) (res * n % 1000000007);
    }
}
