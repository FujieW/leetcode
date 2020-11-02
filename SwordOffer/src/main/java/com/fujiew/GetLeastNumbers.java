package com.fujiew;

import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/1 21:37
 **/
public class GetLeastNumbers {
    public static void main(String[] args) {

    }

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        int i = 0;
        while (i < k) {
            result[i] = arr[i];
            i++;
        }
        return result;
    }
}
