import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/4 11:38
 **/
public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1, 2, 3}));
    }

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(nums, list);
        return res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.addLast(nums[i]);
            backtrack(nums, list);
            list.removeLast();
        }
    }
}
