package com.fujie;

import com.fujie.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/6 23:48
 **/
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<Integer> res = new LinkedList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode root, LinkedList<Integer> res) {

        if (root == null) {
            return;
        }

        inorderTraversal(root.left, res);
        res.addLast(root.val);
        inorderTraversal(root.right, res);
    }
}
