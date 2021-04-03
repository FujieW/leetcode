import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/31 22:35
 **/
public class LevelOrder {
    public static void main(String[] args) {

    }

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 1;
        while (!queue.isEmpty()) {
            TreeNode firstNode = queue.removeFirst();
            if (firstNode == null) {
                // 一层结束
                ans.add(res);
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
                res = new LinkedList<>();
                level++;
                continue;
            }
            if ((level & 1) != 0) {
                res.addLast(firstNode.val);
            } else {
                res.addFirst(firstNode.val);
            }

            if (firstNode.left != null) {
                queue.addLast(firstNode.left);
            }
            if (firstNode.right != null) {
                queue.addLast(firstNode.right);
            }
        }
        return ans;
    }
}
