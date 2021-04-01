import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/1 10:48
 **/
public class Find132pattern {
    public static void main(String[] args) {

    }

    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int k = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (k > -1 && nums[k] > nums[i]) {
                return true;
            }
            if (!stack.isEmpty()) {
                // 弹出可能为 k 的值
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                    k = stack.pop();
                }
            }
            stack.push(i);
        }
        return false;
    }

}
