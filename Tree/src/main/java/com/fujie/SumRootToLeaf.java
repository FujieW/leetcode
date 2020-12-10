package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/10 15:16
 **/
public class SumRootToLeaf {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        SumRootToLeaf sumRootToLeaf = new SumRootToLeaf();
        int sum = sumRootToLeaf.sumRootToLeaf(root);
        System.out.println(sum);
    }

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return postorder(root, 0);

    }

    private int postorder(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }
        num = num * 2 + root.val;
        if (root.left == null && root.right == null) {
            return num;
        }
        int left = postorder(root.left, num);
        int right = postorder(root.right, num);

        return left + right;
    }
}
