package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/10 14:38
 **/
public class KthLargest {

    private int rank = 0;
    int res;
    public int kthLargest(TreeNode root, int k) {
        postorder(root, k);
        return res;
    }

    private void postorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        postorder(root.right, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        postorder(root.left, k);
    }
}
