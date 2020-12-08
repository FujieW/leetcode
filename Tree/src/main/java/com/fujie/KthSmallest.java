package com.fujie;

import com.fujie.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/8 21:29
 **/
public class KthSmallest {
    public static void main(String[] args) {

    }

    ArrayList<Integer> list = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    int result = 0;
    int rank = 0;
    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        rank++;
        if (rank == k) {
            result = root.val;
            return;
        }
        inorder(root.right, k);

    }

}
