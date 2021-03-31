import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/29 22:20
 **/
public class CombinationSum2 {
    public static void main(String[] args) {
        CombinationSum2 sum2 = new CombinationSum2();
        int[] nums = new int[]{1, 1, 2, 5, 6, 7, 10};
        int target = 8;
        System.out.println(sum2.combinationSum2(nums, target));
    }

    private List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> res = new LinkedList<>();
        backtrack(candidates, res, 0, 0, target);
        return ans;
    }
    private void backtrack(int[] candidates, LinkedList<Integer> res, int index, int sum, int target) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new LinkedList<>(res));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            // 去重
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            res.add(candidates[i]);
            backtrack(candidates, res, i + 1, sum + candidates[i], target);
            res.removeLast();
        }
    }
}
