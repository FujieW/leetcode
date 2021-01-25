package com.fujiew;

import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/25 21:35
 **/
public class PrintNumbers {
    public static void main(String[] args) {
        printNumbers2(2);
    }

    public int[] printNumbers(int n) {
        int v = (int) Math.pow(10.0, n) - 1;
        int[] result = new int[v];
        for (int i = 0; i < v; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static void printNumbers2(int n) {
        if (n < 0) {
            return;
        }
        char[] nums = new char[n + 1];
        for (int i = 0; i < 10; i++) {
            char c = (char) (i + '0');
            nums[0] = c;
            printNums(nums, n, 0);

        }

    }

    private static void printNums(char[] nums, int n, int index) {
        if (index == n - 1) {
            String str = new String(nums);
            System.out.println(str);
            return;
        }
        for (int i = 0; i < 10; i++) {
            char c = (char) (i + '0');
            nums[index + 1] = c;
            printNums(nums, n, index + 1);
        }
    }
}
