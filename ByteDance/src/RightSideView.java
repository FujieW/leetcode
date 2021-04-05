import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/5 09:22
 **/
public class RightSideView {
    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        one.left = two;
        one.right = three;
        two.left = four;
        RightSideView rightSideView = new RightSideView();
        System.out.println(rightSideView.rightSideView(one));
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        ArrayList<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        while (!queue.isEmpty()) {
            TreeNode first = queue.removeFirst();
            if (first == null) {
                // 一层结束
                if (queue.isEmpty()) {
                    // 整个结束
                    break;
                }
                queue.add(null);
                temp.add(null);
                continue;
            }
            temp.add(first.val);
            if (first.right != null) {
                queue.addLast(first.right);
            }
            if (first.left != null) {
                queue.addLast(first.left);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(temp.get(0));
        for (int i = 1; i < temp.size(); i++) {
            if (temp.get(i - 1) == null) {
                res.add(temp.get(i));
            }
        }
        return res;
    }

}
