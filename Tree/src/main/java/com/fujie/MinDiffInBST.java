package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/15 18:05
 **/
public class MinDiffInBST {
    int min = Integer.MAX_VALUE;
    int pre = -1;
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        minDiffInBST(root.left);
        if (pre != -1) {
            min = Math.min(min, Math.abs(root.val - pre));
        }
        pre = root.val;
        minDiffInBST(root.right);
        return min;
    }
}
