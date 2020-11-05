package com.fujiew.common;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/5 10:51
 **/
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
