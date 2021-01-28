package com.fujiew;

import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/1 21:37
 **/
public class GetLeastNumbers {
    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] nums = getLeastNumbers.getLeastNumbers2(new int[]{0,0,1,2,4,2,2,3,1,4}, 8);
        System.out.println(Arrays.toString(nums));
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

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr.length <= k) {
            return arr;
        }
        if (k <= 0) {
            return new int[]{};
        }
        int low = 0;
        int high = arr.length - 1;
        while (true) {
            int index = help(arr, k, low, high);
            if (index == k - 1) {
                int[] newArr = new int[k];
                for (int i = 0; i < k; i++) {
                    newArr[i] = arr[i];
                }
                return newArr;
            } else if (k <= index) {
                high = index - 1;
            } else {
                low = index + 1;
            }
        }
    }

    private int help(int[] arr, int k, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
