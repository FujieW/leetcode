import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/29 22:09
 **/
public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        int target = 7;
        CombinationSum sum = new CombinationSum();
        System.out.println(sum.combinationSum(nums, 7));
    }

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> ans = new LinkedList<>();
        backtrack(candidates, 0, 0, ans, target);
        return res;
    }

    private void backtrack(int[] candidates, int index, int sum, LinkedList<Integer> ans, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new LinkedList<>(ans));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            ans.add(candidates[i]);
            backtrack(candidates, i, sum + candidates[i], ans, target);
            ans.removeLast();
        }
    }
}
