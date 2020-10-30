import com.sun.corba.se.impl.orbutil.ObjectUtility;
import common.TreeNode;

import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/29 18:53
 **/
public class SumNumbers {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(2);
        one.right = new TreeNode(3);
        System.out.println(sumNumbers(one));
    }
    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // return dfs(root, root.val);
        return bfs(root);
    }

    /**
     * 深度遍历
     * @param node
     * @param num
     * @return
     */
    private int dfs(TreeNode node, int num) {
        int sum = num * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        } else {
            return dfs(node.left, sum) + dfs(node.right, sum);
        }
    }

    private static int bfs(TreeNode root) {
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> valQueue = new LinkedList<>();
        int sum = 0;
        nodeQueue.push(root);
        valQueue.push(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.pop();
            int num = valQueue.pop();
            if (node.left == null && node.right == null) {
                sum += num;
            } else {
                if (node.left != null) {
                    nodeQueue.push(node.left);
                    valQueue.push(num * 10 + node.left.val);
                }
                if (node.right != null) {
                    nodeQueue.push(node.right);
                    valQueue.push(num * 10 + node.right.val);
                }
            }
        }
        return sum;
    }
}
