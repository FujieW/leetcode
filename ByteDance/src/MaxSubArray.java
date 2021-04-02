/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/2 09:06
 **/
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2};
        MaxSubArray subArray = new MaxSubArray();
        System.out.println(subArray.maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int pre = 0;
        int ans = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            ans = Math.max(ans, pre);
        }
        // System.out.println(ans);
        return ans;
    }
}
