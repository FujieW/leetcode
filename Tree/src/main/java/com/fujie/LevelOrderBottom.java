package com.fujie;

import com.fujie.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/10 17:14
 **/
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            if (pop == null) {
                res.addFirst(temp);
                temp = new LinkedList<>();
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            }
            else {
                temp.add(pop.val);
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
            }

        }

        return res;
    }
}
