package com.fujie;

import com.fujie.common.Node;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/4 16:14
 **/
public class Connect {
    public static void main(String[] args) {

    }

    // 116题
    // 核心： 前序遍历
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        // 前序遍历位置
        left.next = right;

        // 连接该节点的左右节点
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);

        // 连接左节点的右节点 与 右节点的左节点
        connectTwoNode(left.right, right.left);
    }
}
