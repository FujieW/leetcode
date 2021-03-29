/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/16 16:23
 **/
public class Rob {
    public static void main(String[] args) {
        Rob rob = new Rob();
        System.out.println(rob.rob(new int[]{1,2,3,1}));


    }

    public int rob(int[] nums) {
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
