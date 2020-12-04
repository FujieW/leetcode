package com.fujie.common;

import sun.reflect.generics.tree.Tree;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/4 15:58
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        this.left = null;
        this.right = null;
        val = x;
    }

    public TreeNode(int x, TreeNode left, TreeNode right) {
        this.val = x;
        this.left = left;
        this.right = right;
    }
}
