package com.fujie;

import com.fujie.common.TreeNode;
import com.fujie.common.TreeUtils;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/4 22:13
 **/
public class ConstructMaximumBinaryTree {
    public static void main(String[] args) {
        ConstructMaximumBinaryTree c = new ConstructMaximumBinaryTree();
        TreeNode root = c.constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
        TreeUtils.display(root);

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        if (low == high) {
            return new TreeNode(nums[low]);
        }
        int max = nums[low];
        int index = low;

        for (int i = low + 1; i <= high; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(nums, low, index - 1);
        root.right = constructMaximumBinaryTree(nums, index + 1, high);

        return root;
    }
}
