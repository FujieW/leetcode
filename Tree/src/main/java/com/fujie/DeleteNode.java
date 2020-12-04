package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/4 21:51
 **/
public class DeleteNode {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key == root.val) {
            // delete this node
            // 左子树为空
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // 用右子树的最左边节点（最小节点）的值替代要删除的这个节点的值
            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            // 删除右子树的最左边节点
            root.right = deleteNode(root.right, minNode.val);

        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
