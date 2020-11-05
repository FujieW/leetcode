package com.fujiew;

import com.fujiew.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/4 17:21
 **/
public class HasPathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return hasSum(root, sum, 0);
    }

    public boolean hasSum(TreeNode node, int sum, int k) {
        if (node == null) {
            return false;
        }
        if (k + node.val == sum && node.left == null && node.right == null) {
            return true;
        }
        int num = k + node.val;
        return hasSum(node.left, sum, num) || hasSum(node.right, sum, num);
    }
}
