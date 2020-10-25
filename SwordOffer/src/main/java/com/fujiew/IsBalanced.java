package com.fujiew;

import com.fujiew.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/25 22:06
 **/
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 1;
        }
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
