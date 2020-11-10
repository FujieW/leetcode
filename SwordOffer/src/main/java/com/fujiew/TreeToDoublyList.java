package com.fujiew;

import com.fujiew.common.Node;

import java.util.ArrayList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/10 16:44
 **/
public class TreeToDoublyList {
    public static void main(String[] args) {
        Node node = new Node(3);
        Node node1 = treeToDoublyList(node);
        System.out.println(node1.val);

    }

    private static Node head;
    private static Node cur;
    public static Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inOrd(root);
        head.left = cur;
        cur.right = head;
        return head;
    }

    public static void inOrd(Node node) {
        if (node == null) {
            return;
        }
        inOrd(node.left);
        if (cur != null) {
            cur.right = node;
        } else { // 头节点
            head = node;
        }
        node.left = cur;
        cur = node;
        inOrd(node.right);
    }
}
