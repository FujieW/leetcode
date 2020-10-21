package com.fujiew;

import com.fujiew.common.ListNode;
import com.fujiew.common.TreeNode;

import javax.swing.*;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/21 16:55
 **/
public class MirrorTree {
    public static void main(String[] args) {

    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
