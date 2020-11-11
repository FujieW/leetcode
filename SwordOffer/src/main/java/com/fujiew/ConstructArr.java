package com.fujiew;

import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/11 17:26
 **/
public class ConstructArr {
    public static void main(String[] args) {

    }
    
    public int[] constructArr(int[] a) {
        if (a == null || a.length <= 0) {
            return new int[0];
        }
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
