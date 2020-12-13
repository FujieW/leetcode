package com.fujie;

import com.fujie.common.TreeNode;

import java.util.ArrayList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/11 09:16
 **/
public class GetMinimumDifference {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        GetMinimumDifference getMinimumDifference = new GetMinimumDifference();
        int minimumDifference = getMinimumDifference.getMinimumDifference(root);
        System.out.println(minimumDifference);

    }

    private int min = Integer.MAX_VALUE;
    private int curr = -1;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (curr != -1) {

            min = Math.min(min, Math.abs(root.val - curr));
        }
        System.out.println("前"+curr);
        curr = root.val;
        System.out.println("后"+curr);
        inorder(root.right);
    }
}
