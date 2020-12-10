package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/10 14:51
 **/
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        return preorder(root, sum);
    }

    private boolean preorder(TreeNode root, int sum) {

        if (root == null || sum < 0) {
            return false;
        }


        if (sum - root.val == 0 && root.left == null && root.right == null) {
            return true;
        }
        sum -= root.val;
        return preorder(root.left, sum) || preorder(root.right, sum);
    }
}
