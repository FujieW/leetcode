package com.fujiew;

import sun.applet.Main;

/**
 * 剑指Offer第四题， 在二维数组中查找值。
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/19 23:02
 **/
public class FindNumberInTwoArray {
    public static void main(String[] args) {
        System.out.println(findNumberIn2DArray(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},20));
    }

    /**
     * 从右上角往下遍历
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            // 列 或者 行 为 0 的时候直接返回false
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length-1;
        int i = 0, j = col; // i->行, j->列
        while (i < row && j >=0){
                int temp = matrix[i][j];
                if (temp == target) {
                    return true;
                } else if (matrix[i][j] < target) {
                    i++;
                } else {
                    j--;
                }
        }
        return false;
    }
}
