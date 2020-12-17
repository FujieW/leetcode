package com.fujie;

import com.fujie.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/17 08:48
 **/
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        help(root1, res1);
        help(root2, res2);
        if (res1.size() != res2.size()) {
            return false;
        }
        for (int i = 0; i < res1.size(); i++) {
            if (res1.get(i) != res2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void help(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        help(root.left, res);
        if (root.left == null && root.right == null) {
            res.add(root.val);
        }
        help(root.right, res);
    }
}
