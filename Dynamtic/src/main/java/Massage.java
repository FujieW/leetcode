/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/18 17:45
 **/
public class Massage {
    public static void main(String[] args) {
        Massage massage = new Massage();
        System.out.println(massage.massage(new int[]{2,1,2,2}));
    }

    public int massage(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len-1];
    }
}
