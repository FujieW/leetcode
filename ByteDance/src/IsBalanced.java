import common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/7 10:14
 **/
public class IsBalanced {
    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {
        int height = height(root);
        return height != -1;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
