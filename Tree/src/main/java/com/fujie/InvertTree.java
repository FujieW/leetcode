package com.fujie;

import com.fujie.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/4 15:59
 **/
public class InvertTree {
    // 反转二叉树
    // 核心： 二叉树前序遍历（后序遍历也是可以的）
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
