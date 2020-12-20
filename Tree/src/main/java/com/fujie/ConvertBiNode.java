package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/20 16:45
 **/
public class ConvertBiNode {
    public static void main(String[] args) {

    }

    TreeNode ans = new TreeNode(-1);
    TreeNode pre = null;
    public TreeNode convertBiNode(TreeNode root) {
        help(root);
        return ans.right;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        help(root.left);
        if (pre == null) {
            pre = root;
            ans.right = root;
        } else {
            pre.right = root;
            pre = root;
        }
        root.left = null;
        help(root.right);
    }
}
