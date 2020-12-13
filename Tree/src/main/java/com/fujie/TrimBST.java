package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/13 17:02
 **/
public class TrimBST {
    public static void main(String[] args) {

    }

    /**
     * 思路是重新构建一颗新的树，不要删除
     * @param root
     * @param low
     * @param high
     * @return
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        return postorder(root, low, high);
    }

    private TreeNode postorder(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return postorder(root.right, low, high);
        }
        if (root.val > high) {
            return postorder(root.left, low, high);
        }

        root.left = postorder(root.left, low, high);
        root.right = postorder(root.right, low, high);
        return root;
    }


}
