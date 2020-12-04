package com.fujie.common;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/4 22:21
 **/
public class TreeUtils {
    public static void main(String[] args) {

    }

    public static void display(TreeNode root) {
        if (root == null) {
            return;
        }
        display(root.left);
        System.out.println(root.val);
        display(root.right);

    }

}
