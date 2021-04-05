/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/5 10:41
 **/
public class LengthOfLIS {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
