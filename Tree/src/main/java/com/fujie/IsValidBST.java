package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/4 17:01
 **/
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    // 98 题
    // 核心前序遍历
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }

        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        boolean left = isValidBST(root.left, min, root);
        boolean right = isValidBST(root.right, root, max);
        return left && right;
    }
}
