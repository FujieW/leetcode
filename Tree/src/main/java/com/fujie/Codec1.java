package com.fujie;

import com.fujie.common.TreeNode;
import sun.awt.image.ImageWatched;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/7 10:20
 **/
public class Codec1 {

    // 后序序列化

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }

        serialize(root.left, sb);
        serialize(root.right, sb);

        sb.append(root.val).append(",");
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
        String rootValue = nodes.removeLast();
        if ("#".equals(rootValue)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootValue));
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);

        return root;
    }

}
