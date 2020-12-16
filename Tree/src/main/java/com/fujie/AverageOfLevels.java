package com.fujie;

import com.fujie.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/16 22:28
 **/
public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Double> res = new ArrayList<>();
        queue.addLast(root);
        queue.add(null);
        double sum = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node != null) {
                sum += node.val;
                count++;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                res.add(sum / count);
                sum = 0;
                count = 0;
                if (queue.isEmpty()) {
                    break;
                }
                queue.add(null);
            }
        }
        return res;
    }
}
