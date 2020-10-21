package com.fujiew;

import com.fujiew.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/21 17:14
 **/
public class IsSymmetric {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {

        return root == null || isEqual(root.left, root.right);

    }

    private boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }


}
