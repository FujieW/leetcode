package com.fujie;

import com.fujie.common.TreeNode;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/10 15:43
 **/
public class Tree2str {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        preorder(t, sb);
        return sb.toString();
    }

    public void preorder(TreeNode root, StringBuilder sb) {
        if(root == null){
            return;
        }

        sb.append(root.val);

        if(root.left != null){
            sb.append("(");
            preorder(root.left,sb);
            sb.append(")");
        } else if(root.right != null){
            // when left is null and right is not nul null
            sb.append("()");
        }

        if(root.right != null){
            sb.append("(");
            preorder(root.right, sb);
            sb.append(")");
        }
    }
}
