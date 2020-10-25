package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/25 21:35
 **/
public class PrintNumbers {
    public static void main(String[] args) {

    }

    public int[] printNumbers(int n) {
        int v = (int) Math.pow(10.0, n) - 1;
        int[] result = new int[v];
        for (int i = 0; i < v; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
