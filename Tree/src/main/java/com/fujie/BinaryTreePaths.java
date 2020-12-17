package com.fujie;

import com.fujie.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/17 09:00
 **/
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        // StringBuilder sb = new StringBuilder();
        help(root, "");
        return res;
    }

    private List<String> res = new ArrayList<>();
    private void help(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        s+=(root.val);
        if (root.left == null && root.right == null) {
            res.add(s);
        }
        boolean flag = false;
        if (root.left != null) {
            s+=("->");
            flag = true;
            help(root.left, s);
        }
        if (root.right != null) {
            if (!flag) {
                s += ("->");
            }
            help(root.right, s);
        }
    }
}
