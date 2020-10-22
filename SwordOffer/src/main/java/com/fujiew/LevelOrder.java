package com.fujiew;

import com.fujiew.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/22 10:37
 **/
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        three.left = nine;
        three.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;
        System.out.println(levelOrder(three));
        System.out.println(levelOrder(null));

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
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
                // System.out.println();
                result = new ArrayList<>();
                nodes.add(null);
                continue;
            }
            result.add(node.val);
            // System.out.println(node.val + " ");
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }

        return results;
    }
}
