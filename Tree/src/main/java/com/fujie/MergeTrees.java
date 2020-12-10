package com.fujie;

import com.fujie.common.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/10 16:51
 **/
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        return preorder(t1, t2);
    }

    private TreeNode preorder(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        System.out.println(root.val);
        root.left = preorder(t1.left, t2.left);

        root.right = preorder(t1.right, t2.right);
        return root;
    }
}
