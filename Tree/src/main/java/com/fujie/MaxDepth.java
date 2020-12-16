package com.fujie;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/16 22:39
 **/
public class MaxDepth {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        System.out.println(root.val);
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(maxDepth(child), max);
        }
        return max + 1;
    }
}
