package com.fujiew;

import com.fujiew.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/25 22:00
 **/
public class MaxDepth {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }
}
