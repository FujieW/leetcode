package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/13 14:36
 **/
public class IsUnivalTree {
    boolean flag = true;
    public boolean isUnivalTree(TreeNode root) {
        return inorder(root, root.val);
    }

    private Boolean inorder(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            flag = false;
        }
        inorder(root.left, val);
        inorder(root.right, val);
        return flag;
    }
}
