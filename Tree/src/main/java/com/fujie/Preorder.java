package com.fujie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/9 17:26
 **/
public class Preorder {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        list.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return list;
    }
}
class Node{
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}