package com.fujie;

import com.fujie.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/17 08:28
 **/
public class RangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        help(root, low, high);
        return k;
    }

    private int k = 0;
    private void help(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        help(root.left, low, high);
        if (root.val >= low && root.val <= high) {
            k += root.val;
        }
        help(root.right, low, high);
    }
}
