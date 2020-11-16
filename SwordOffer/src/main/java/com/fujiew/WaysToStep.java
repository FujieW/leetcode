package com.fujiew;

import java.util.Queue;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/16 15:52
 **/
public class WaysToStep {
    public static void main(String[] args) {
        WaysToStep waysToStep = new WaysToStep();

        System.out.println(waysToStep.waysToStep(61));
    }

    public int waysToStep(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 4;
        }

        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        return (int) waysToStepRecursiveUtil(n, dp);
    }

    public long waysToStepRecursiveUtil(int n, long[] dp) {
        if (n <= 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = (waysToStepRecursiveUtil(n - 1, dp) + waysToStepRecursiveUtil(n - 2, dp) + waysToStepRecursiveUtil(n - 3, dp)) % 1000000007;
        return dp[n];
    }
}
