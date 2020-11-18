import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/16 17:12
 **/
public class NumArray {
    private final int[] nums;
    private int[] sums;
    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length + 1];
        init();
    }

    public void init() {
        sums[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i-1];
        }
        //  System.out.println(Arrays.toString(sums));

    }

    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 1));

    }
}
