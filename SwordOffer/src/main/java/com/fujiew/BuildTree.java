package com.fujiew;

import sun.reflect.generics.tree.Tree;

/**
 * 剑指 Offer 第七题
 *
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/20 14:14
 **/
public class BuildTree {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return reBuildTree(0, preorder.length - 1, preorder, 0, inorder.length - 1, inorder);
    }

    /**
     * 递归用构建树
     *
     * @param startPre 前序遍历的最左下标
     * @param endPre   前序遍历的最右下表
     * @param pre      谦虚遍历的数组
     * @param startIn  中序遍历的最左下标
     * @param endIn    中序遍历的最右下标
     * @param in       中序遍历的数组
     * @return
     */
    private TreeNode reBuildTree(int startPre, int endPre, int[] pre, int startIn, int endIn, int[] in) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startIn]) {
                root.left = reBuildTree(startPre + 1, i - startIn + startPre, pre, startIn, i - 1, in);
                root.right = reBuildTree(startPre + i + 1 - startIn, endPre, pre, i + 1, endIn, in);
                break;
            }
        }
        return root;
    }
}
