package com.fujiew;

import com.fujiew.common.ListNode;
import com.fujiew.common.TreeNode;

import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/27 21:56
 **/
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            TreeNode top = queue.removeFirst();
            if (top == null) {
                sb.append("#").append(",");
            } else {
                sb.append(top.val).append(",");
                queue.addLast(top.left);
                queue.addLast(top.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        // 1 2 3 # # 4 5
        String[] split = data.split(",");
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        queue.add(root);
        int i = 1;
        while (i < split.length) {
            TreeNode pop = queue.removeFirst();
            String left = split[i++];
            if (!"#".equals(left)) {
                pop.left = new TreeNode(Integer.parseInt(left));
                queue.addLast(pop.left);
            } else {
                pop.left = null;
            }

            String right = split[i++];
            if (!"#".equals(right)) {
                pop.right = new TreeNode(Integer.parseInt(right));
                queue.addLast(pop.right);
            } else {
                pop.right = null;
            }
        }
        return root;
    }
}
