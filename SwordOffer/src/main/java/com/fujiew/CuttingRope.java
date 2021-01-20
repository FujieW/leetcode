package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/3 14:21
 **/
public class CuttingRope {
    public static void main(String[] args) {
        System.out.println(cuttingRope2(10));
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

    public static int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int temp = dp[j] * dp[i - j];
                if (temp > max) {
                    max = temp;
                }
                dp[i] = max;
            }
        }
        max = dp[n];
        return max;
    }
}
