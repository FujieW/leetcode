package com.fujiew;

import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/21 15:39
 **/
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));

    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix.length * matrix[0].length];
        System.out.println(result.length);
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        int k = 0;
        while (left <= right && top <= down) {
            // 左 → 右
            for (int column = left; column <= right; column++) {
                result[k++] = matrix[top][column];
            }
            // 上 → 下

            for (int row = top + 1; row <= down; row++) {
                result[k++] = matrix[row][right];
            }

            if (top < down && left < right) {
                // 右 → 左
                for (int dColumn = right - 1; dColumn > left; dColumn--) {
                    result[k++] = matrix[down][dColumn];
                }
                // 下 → 上
                for (int dRow = down; dRow > top; dRow--) {
                    result[k++] = matrix[dRow][left];
                }
            }
            left++;
            right--;
            top++;
            down--;
        }
        return result;
    }
}
