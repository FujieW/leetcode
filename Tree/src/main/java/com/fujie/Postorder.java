package com.fujie;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/17 08:34
 **/
public class Postorder {
    public static void main(String[] args) {

    }

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        help(root, res);
        res.add(root.val);
        return res;
    }

    private void help(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            help(child, res);
            res.add(child.val);
        }
    }
}
