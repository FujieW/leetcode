package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/4 16:42
 **/
public class Flatten {
    public static void main(String[] args) {

    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
