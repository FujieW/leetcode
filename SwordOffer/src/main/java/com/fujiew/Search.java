package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/10/22 14:45
 **/
public class Search {
    public static void main(String[] args) {
        int low = 3;
        int high = 5;

        int a = (high - low) >> 1;
        System.out.println(a);
        System.out.println(low + a);

        System.out.println(search2(new int[]{-1, 0, 3, 5, 9, 12}, 9));
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
                for (int i = mid + 1; i < nums.length; i++) {
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

    // 正常的二分查找
    public static int search2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) { // 这里是 小于等于
            int mid = low + ((high - low) >> 1); // 因为 （low + high）/2 ,low+high 可能非常大，越界
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 返回第一个等于该值的元素的下标
    public static int search3(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    // 返回最后一个等于该值的元素
    public static int search4(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + ((high - low) >> 1);
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] != target) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }


    // 查找第一个大于等于给定值的元素
    public static int search5(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
