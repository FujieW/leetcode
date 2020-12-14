package com.fujie;

import com.fujie.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/14 17:29
 **/
public class IsCousins {
    public static void main(String[] args) {
        IsCousins isCousins = new IsCousins();
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root.left = two;
        two.right = four;
        root.right = three;
        three.right = five;

        System.out.println(isCousins.isCousins(root, 4, 3));
    }

    private Map<Integer, TreeNode> parent;
    private Map<Integer, Integer> depth;


    public boolean isCousins(TreeNode root, int x, int y) {
        parent = new HashMap<>();
        depth = new HashMap<>();
        firstOrder(root, null);
        return depth.get(x).equals(depth.get(y)) && parent.get(x) != parent.get(y);
    }


    private void firstOrder(TreeNode node, TreeNode par) {
        if (node == null) {
            return;
        }
        depth.put(node.val, par == null ? 0 : depth.get(par.val) + 1);
        parent.put(node.val, par);
        firstOrder(node.left, node);
        firstOrder(node.right, node);
    }
}
