package com.fujie;

import com.fujie.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/14 18:22
 **/
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return Math.max(max - 1, 0);
    }

    private int max = 0;
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        max = Math.max(max, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
