package com.fujiew;

import com.fujiew.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/4 17:32
 **/
public class PathSum {
    public static void main(String[] args) {

    }

    private List<List<Integer>> results = new LinkedList<>();
    private LinkedList<Integer> result = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        hasSum(root, sum, 0);
        return results;
    }

    public void hasSum(TreeNode node, int sum, int k) {
        if (node == null) {
            return;
        }
        this.result.add(node.val);
        int num = k + node.val;
        if (num == sum && node.left == null && node.right == null) {
            results.add(new LinkedList<>(this.result));
        }
        hasSum(node.left, sum, num);
        hasSum(node.right, sum, num);
        result.removeLast();
    }
}
