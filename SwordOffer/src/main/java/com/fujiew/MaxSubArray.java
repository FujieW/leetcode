package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/25 21:40
 **/
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, 5, 4}));
        System.out.println(maxSubArray2(new int[]{-1}));

    }

    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int max = dp[0];
        for (int j : dp) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    public static int maxSubArray2(int[] nums) {
        int[][] dp = new int[nums.length][2];
        int len = nums.length;
        dp[0][0] = Integer.MIN_VALUE;
        dp[0][1] = nums[0];

        for (int i = 1; i < len; i ++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][1] + nums[i], nums[i]);
        }
        return Math.max(dp[len-1][0], dp[len-1][1]);
    }
}
