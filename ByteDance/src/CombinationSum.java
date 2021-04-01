import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/1 10:41
 **/
public class CombinationSum {
    public static void main(String[] args) {

    }

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<Integer> res = new LinkedList<>();
        backtrack(candidates, res, 0, target, 0);
        return ans;
    }

    private void backtrack(int[] candidates, LinkedList<Integer> res, int sum, int target, int index) {
        if (sum == target) {
            ans.add(new LinkedList<>(res));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            res.add(candidates[i]);
            backtrack(candidates, res, sum + candidates[i], target, i);
            res.removeLast();
        }
    }
}
