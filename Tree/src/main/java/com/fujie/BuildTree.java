package com.fujie;

import com.fujie.common.TreeNode;
import com.fujie.common.TreeUtils;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/5 11:25
 **/
public class BuildTree {
    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree.buildTree(preorder, inorder);
        TreeUtils.display(root);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    // 先序遍历
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int rootValue = preorder[preLeft];
        TreeNode root = new TreeNode(rootValue);

        int index = inLeft;
        for (; index < inRight; index++) {
            if (inorder[index] == rootValue) {
                break;
            }
        }

        root.left = buildTree(preorder, preLeft + 1, preLeft + index - inLeft, inorder, inLeft, index - 1);
        root.right = buildTree(preorder, index + preLeft - inLeft + 1, preRight, inorder, index + 1, inRight);
        return root;
    }
}
