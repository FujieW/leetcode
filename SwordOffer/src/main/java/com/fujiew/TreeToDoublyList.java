package com.fujiew;

import com.fujiew.common.Node;

import java.util.ArrayList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/10 16:44
 **/
public class TreeToDoublyList {
    private Node prev = null;
    private Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inorder(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (prev != null) {
            prev.right = root;
        } else {
            head = root;
        }
        root.left = prev;
        prev = root;
        inorder(root.right);

    }
}
