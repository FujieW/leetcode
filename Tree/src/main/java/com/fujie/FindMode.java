package com.fujie;

import com.fujie.common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/12/18 08:42
 **/
public class FindMode {

    public int[] findMode(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        // System.out.println(res);
        help(root, res);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    int curr = -1;
    int currCount = 0;
    int maxCount = 0;
    private void help(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        help(root.left, res);
        if (curr == root.val) {
            currCount++;
        } else {
            currCount = 1;
            curr = root.val;
        }
        if (currCount == maxCount) {
            res.add(curr);
        }
        if (currCount > maxCount) {
            maxCount = currCount;
            res.clear();
            res.add(curr);
        }
        // System.out.println(res);
        help(root.right, res);
    }
}
