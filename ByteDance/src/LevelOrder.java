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
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode firstNode = queue.removeFirst();
            if (firstNode == null) {
                // 一层结束
                ans.add(list);
                if (queue.isEmpty()) {
                    // 最后一层
                    break;
                }
                list = new LinkedList<>();
                queue.add(null);
                continue;
            }
            list.addLast(firstNode.val);
            if (firstNode.left != null) {
                queue.add(firstNode.left);
            }
            if (firstNode.right != null) {
                queue.add(firstNode.right);
            }
        }
        return ans;
    }
}
