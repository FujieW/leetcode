package com.fujie;

import com.fujie.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/7 18:19
 **/
public class Codec2 {
    // 中序

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.addLast(root);

        while (!nodes.isEmpty()) {
            TreeNode currNode = nodes.removeFirst();
            if (currNode == null) {
                sb.append("#").append(",");
                continue;
            }
            sb.append(currNode.val).append(",");
            System.out.print(currNode.val+", ");
            nodes.addLast(currNode.left);
            nodes.addLast(currNode.right);

        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        System.out.println(data);
        String[] nodes = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        LinkedList<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        int i = 1;
        while (i < nodes.length) {
            TreeNode curr = q.pop();
            String left = nodes[i++];
            if (!"#".equals(left)) {
                curr.left = new TreeNode(Integer.parseInt(left));
                q.addLast(curr.left);
            } else {
                curr.left = null;
            }

            String right = nodes[i++];
            if (!"#".equals(right)) {
                curr.right = new TreeNode(Integer.parseInt(right));
                q.addLast(curr.right);

            } else {
                curr.right = null;
            }
        }
        return root;
    }
}
