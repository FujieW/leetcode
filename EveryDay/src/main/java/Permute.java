import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/6 11:52
 **/
public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1, 2, 3}));
    }

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> result = new LinkedList<>();
        permute(nums, result);
        return res;
    }

    private void permute(int[] nums, LinkedList<Integer> result) {
        if (result.size() == nums.length) {
            res.add(new LinkedList<>(result));
            // System.out.println(res);
            return;
        }
        for (int num : nums) {
            if (result.contains(num)) {
                continue;
            }
            // 做选择
            result.add(num);
            // 下一次决策
            permute(nums, result);
            // 撤销选择
            result.removeLast();
        }

    }
}
