package com.fujie.common;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/4 16:12
 **/
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}
