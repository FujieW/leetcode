package com.fujie;

import com.fujie.common.TreeNode;
import com.fujie.common.TreeUtils;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/5 20:33
 **/
public class BuilderTree2 {
    public static void main(String[] args) {
        BuilderTree2 buildTree = new BuilderTree2();
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree.buildTree(inorder, postorder);
        TreeUtils.display(root);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, int postLeft, int postRight, int[] inorder, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }

        int rootValue = postorder[postRight];
        TreeNode root = new TreeNode(rootValue);

        int index = inLeft;
        for (; index <= inRight; index++) {
            if (inorder[index] == rootValue) {
                break;
            }
        }

        root.left = buildTree(postorder, postLeft, postLeft + index - inLeft - 1, inorder, inLeft, index - 1);
        root.right = buildTree(postorder, postLeft + index - inLeft, postRight - 1, inorder, index + 1, inRight);

        return root;
    }
}
