package com.fujiew.common;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/5 10:51
 **/
 public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
