package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/17 18:16
 **/
public class IsSubtree {
    public static void main(String[] args) {

    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSamaTree(s, t);
    }

    private boolean isSamaTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSamaTree(s.left, t.left) && isSamaTree(s.right, t.right);
    }
}
