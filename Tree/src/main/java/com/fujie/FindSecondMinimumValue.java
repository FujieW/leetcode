package com.fujie;

import com.fujie.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/14 21:57
 **/
public class FindSecondMinimumValue {

    public static void main(String[] args) {
        FindSecondMinimumValue findSecondMinimumValue = new FindSecondMinimumValue();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        System.out.println(findSecondMinimumValue.findSecondMinimumValue(root));
    }

    /**
     * 思路：一个结点如果存在子树，左右子树要么值相等，要么不相等
     * 不相等：在当前树中，较小的值和节点的值一样，第二小的必然是更大的那个。所以我们将返回结果res设置为该较大的值，因为较大的值在他的子树中一定是最小的值了，所以对较小值的树进行递归查找，是否会有更小的第二小的值（此处有点绕需要理解）
     * 若相等：分别递归左右子树
     *
     */
    int ans = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return ans;
        }
        if (root.left != null && root.right != null && root.left.val != root.right.val) {
            int bigger = Math.max(root.left.val, root.right.val);
            ans = ans == -1 ? bigger : Math.min(ans, bigger);
            findSecondMinimumValue(root.left.val > root.right.val ? root.right : root.left);
        } else {
            findSecondMinimumValue(root.left);
            findSecondMinimumValue(root.right);
        }
        return ans;
    }


}
