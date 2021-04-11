import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/11 17:11
 **/
public class PathSum {
    public static void main(String[] args) {

    }


    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        LinkedList<Integer> res = new LinkedList<>();
        dfs(root, res, 0, sum);
        return ans;
    }

    private void dfs(TreeNode root, LinkedList<Integer> res, int sum, int target) {
        if (root == null) {
            return;
        }

        res.addLast(root.val);
        int num = sum + root.val;
        if (num == target && root.left == null && root.right == null) {
            ans.add(new LinkedList<>(res));
        }
        dfs(root.left, res, num, target);
        dfs(root.right, res, num, target);
        res.removeLast();
    }
}
