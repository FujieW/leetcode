package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/13 16:46
 **/
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2, 5, 6}, 27));
    }

    /*public static int digui(int[] coins, int amount) {

    }*/
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            dp[amount] = -1;
        }
        return dp[amount];
    }
}
