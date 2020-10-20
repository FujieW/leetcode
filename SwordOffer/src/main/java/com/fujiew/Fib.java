package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/20 17:13
 **/
public class Fib {
    public static void main(String[] args) {
        System.out.println(fib(1));
    }

    public static int fib(int n) {
        if (n <= 1) {
            return 1;
        }
        int f0 = 1;
        int f1 = 2;
        int f3 = 2;
        for (int i = 2; i < n; i++) {
            f3 = (f1 + f0) % 1000000007;
            f0 = f1;
            f1 = f3;
        }
        return f3;
    }

    // 动态规划解法
    public static int fib2(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
