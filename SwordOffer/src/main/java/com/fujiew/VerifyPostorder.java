package com.fujiew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/4 17:07
 **/
public class VerifyPostorder {
    public static void main(String[] args) {
        VerifyPostorder verifyPostorder = new VerifyPostorder();

        System.out.println(verifyPostorder.verifyPostorder(new int[]{1, 6, 3, 2, 5}));


    }

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if (i == j) {
            return true;
        }

        int low = i;
        int root = postorder[j];
        // 前半段
        while (postorder[low] < root) {
            low++;
        }
        // 后半段
        int high = low;
        while (postorder[high] > root) {
            high++;
        }

        return high == j && recur(postorder, i, low - 1) && recur(postorder, low, j - 1);
    }

}
