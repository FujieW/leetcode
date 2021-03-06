import common.TreeNode;

import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/6 19:55
 **/
public class MinDepth {
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int minDepth = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode first = queue.removeFirst();
                if (first.left == null && first.right == null) {
                    return minDepth;
                }
                // 其他相邻节点加入队列
                if (first.left != null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }
}
