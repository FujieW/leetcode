import common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/7 10:07
 **/
public class MaxDepth {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
