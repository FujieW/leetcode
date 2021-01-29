package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/29 09:16
 **/
public class ReversePairs {
    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int count = reversePairs.reversePairs(new int[]{7, 5, 6, 4});
        System.out.println(count);
    }

    public int reversePairs(int[] nums) {
        int count = help(nums, 0, nums.length - 1);
        return count;
    }

    private int help(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = low + ((high - low) >> 1);
        int left = help(nums, low, mid);
        int right = help(nums, mid + 1, high);
        int count = merge(nums, low, mid, mid + 1, high);
        return left + right + count;
    }

    private int merge(int[] nums, int low, int mid, int mid1, int high) {
        int[] arr = new int[high - low + 1];
        int k = high - low;
        int count = 0;
        while (mid >= low && high >= mid1) {
            if (nums[mid] > nums[high]) {
                count += high - mid1 + 1;
                arr[k--] = nums[mid--];

            } else if (nums[mid] <= nums[high]) {
                arr[k--] = nums[high--];
            }
        }
        while (mid >= low) {
            arr[k--] = nums[mid--];
        }
        while (high >= mid1) {
            arr[k--] = nums[high--];
        }
        System.arraycopy(arr, 0, nums, low, arr.length);
        return count;
    }
}
