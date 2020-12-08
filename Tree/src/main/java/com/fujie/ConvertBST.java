package com.fujie;

import com.fujie.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/8 22:21
 **/
public class ConvertBST {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
