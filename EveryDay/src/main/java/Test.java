import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/29 14:22
 **/
public class Test {
    public static void main(String[] args) {

    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = help(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode help(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);

        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                root.left = help(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = help(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        help(list, listNode);
        return list;
    }

    private void help(ArrayList<Integer> list, ListNode listNode) {
        if (listNode == null) {
            return;
        }
        help(list, listNode.next);
        list.add(listNode.val);
    }
}
