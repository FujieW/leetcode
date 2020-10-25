package com.fujiew;

import com.fujiew.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/25 22:18
 **/
public class KthLargest {
    public static void main(String[] args) {

    }

    private int k;
    private int value;
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        this.k = k;
        displayTree(root);
        return this.value;
    }

    private void displayTree(TreeNode node) {
        if (node == null) {
            return;
        }
        displayTree(node.right);
        if (k <= 0) {
            return;
        }
        if (--this.k <= 0) {
            this.value = node.val;
        }
        displayTree(node.left);
    }
}
