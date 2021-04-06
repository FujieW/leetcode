import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/6 10:36
 **/
public class PreorderTraversal {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        firstOrder(root, res);
        return res;
    }

    private void firstOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        firstOrder(root.left, res);
        firstOrder(root.right, res);

    }
}
