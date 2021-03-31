import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/31 22:26
 **/
public class ZigzagLevelOrder {
    public static void main(String[] args) {

    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node == null) {
                // 一层结束
                level++;
                ans.add(res);
                if (queue.isEmpty()) {
                    break;
                }
                res = new LinkedList<>();
                queue.add(null);
                continue;
            }
            if ((level & 1) != 0) {
                res.addLast(node.val);
            } else {
                res.addFirst(node.val);
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return ans;
    }
}
