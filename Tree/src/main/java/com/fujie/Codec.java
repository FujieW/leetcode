package com.fujie;

import com.fujie.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/6 23:04
 **/
public class Codec {
    public static void main(String[] args) {

    }

    // 前序序列化

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();

        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        String SEP = ",";
        if (root == null) {
            String NULL = "#";
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);

        serialize(root.left, sb);
        serialize(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String rootValue = nodes.removeFirst();
        if ("#".equals(rootValue)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootValue));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}
