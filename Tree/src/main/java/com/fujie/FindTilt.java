package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/20 17:01
 **/
public class FindTilt {
    public int findTilt(TreeNode root) {
        help(root);
        return sum;
    }

    private int sum = 0;
    private int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = help(root.left);
        int right = help(root.right);
        int diff = Math.abs(left - right);
        sum += diff;
        return left + right + root.val;
    }

}
