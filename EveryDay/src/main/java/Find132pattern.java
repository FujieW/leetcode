import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/31 10:53
 **/
public class Find132pattern {
    public static void main(String[] args) {
        Find132pattern pattern = new Find132pattern();
        int[] nums = new int[]{3, 4, 6, 4, 3, -1, 6};
        pattern.find132pattern(nums);
    }

    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int k = -1;
        // 构造单调栈
        for (int i = nums.length - 1; i >= 0; i--) {
            if (k > -1 && nums[k] > nums[i]) {
                return true;
            }
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    k = stack.pop();
                }
            }
            stack.push(i);
        }
        return false;
    }
}
