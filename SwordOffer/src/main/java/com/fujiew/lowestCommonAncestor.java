package com.fujiew;

import com.fujiew.common.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/30 14:55
 **/
public class lowestCommonAncestor {
    public static void main(String[] args) {

    }

    ArrayList<TreeNode> pList = null;
    ArrayList<TreeNode> qList = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        if (root.val < p.val && root.val < q.val) {
            // 两个节点在根节点右侧
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            // 两个节点在根节点左侧
            return lowestCommonAncestor(root.left, p, q);
        } else {
            // 两个节点在根节点两侧
            return root;
        }
    }

}
