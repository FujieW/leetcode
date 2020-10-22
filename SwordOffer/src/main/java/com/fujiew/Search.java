package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/22 14:45
 **/
public class Search {
    public static void main(String[] args) {
        System.out.println(search(new int[]{8, 8, 8, 8, 8, 8, 8, 8, 8}, 8));
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int count = 0;
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                // 向前查找次数
                for (int i = mid; i >= 0; i--) {
                    if (nums[i] == target) {
                        count++;
                    } else {
                        break;
                    }
                }
                // 向后查找次数
                for (int i = mid + 1; i < nums.length ; i++) {
                    if (nums[i] == target) {
                        count++;
                    } else {
                        break;
                    }
                }
                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return count;
    }
}
