package com.fujie;

import com.fujie.common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/8 21:02
 **/
public class FindDuplicateSubtrees {
    public static void main(String[] args) {

    }

    HashMap<String, Integer> map = new HashMap<>();
    LinkedList<TreeNode> list = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postorder(root);
        return list;
    }

    private String postorder(TreeNode root) {

        if (root == null) {
            return "#";
        }
        String left = postorder(root.left);
        String right = postorder(root.right);
        String subtree = left + "," + right + "," + root.val;
        Integer count = map.getOrDefault(subtree, 0);
        if (count == 1) {
            list.addLast(root);
        }
        map.put(subtree, count + 1);
        return subtree;
    }
}
