package com.fujiew;

import java.util.ArrayList;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/25 23:25
 **/
public class FindContinuousSequence {
    public static void main(String[] args) {
        System.out.println(findContinuousSequence(9));

    }

    public static int[][] findContinuousSequence(int target) {
        ArrayList<int[]> result = new ArrayList<>();
        int left = 1;
        int right = 2;
        while (left < right) {
            int sum = (left + right) * (right - left + 1) >> 1;
            if (sum < target) {
                right++;
            } else if (sum > target) {
                left++;
            } else {
                int[] temp = new int[right - left + 1];
                for (int i = left; i <= right; i++) {
                    temp[i - left] = i;
                }
                result.add(temp);
                left++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}
