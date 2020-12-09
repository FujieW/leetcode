package com.fujie;

import com.fujie.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/9 21:15
 **/
public class LevelOrder {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(null);
        // System.out.println(queue.size());
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            if (pop == null) {
                res.add(temp);
                temp.clear();
                System.out.println(temp);
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
