package com.fujiew;

import com.fujiew.common.TreeNode;

import java.util.*;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/22 10:37
 **/
public class LevelOrder {
    public static void main(String[] args) {

    }

    /**
     * 层次遍历第一题
     *
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            result.add(pop.val);
            if (pop.left != null) {
                queue.add(pop.left);
            }
            if (pop.right != null) {
                queue.add(pop.right);
            }
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;

    }
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        // 将根节点添加进去队列
        nodes.add(root);
        nodes.add(null);
        int level = 1;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.remove();
            if (node == null) {
                results.add(result);
                // 到最后
                if (nodes.isEmpty()) {
                    break;
                }
                level++;
                result = new ArrayList<>();
                nodes.add(null);
                continue;
            }
            result.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }

        return results;
    }
    public static List<List<Integer>> levelOrder3(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> nodes = new LinkedList<>();
        List<List<Integer>> results = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        nodes.add(root);
        nodes.add(null);
        int level = 1;
        while (!nodes.isEmpty()) {
            TreeNode firstNode = nodes.pop();
            if (firstNode == null) {
                results.add(result);
                if (nodes.isEmpty()) {
                    break;
                }
                level++;
                result = new LinkedList<>();
                nodes.add(null);
                continue;
            }
            if ((level & 1) != 0) {
                result.addLast(firstNode.val);
            } else {
                result.addFirst(firstNode.val);
            }
            if (firstNode.left != null) {
                nodes.add(firstNode.left);
            }
            if (firstNode.right != null) {
                nodes.add(firstNode.right);
            }
        }
        return results;
    }
}
