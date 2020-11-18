/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/16 16:23
 **/
public class Rob {
    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob2(new int[]{2,1,2}));
    }

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (i < 2) {
                dp[i][0] = dp[i - 1][1];
            } else {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]);
            }
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i-1]);
        }
        return dp[nums.length];
    }
}
