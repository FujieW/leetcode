/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/5 10:59
 **/
public class Search {
    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            // 后半部分有序
            if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) { // 在有序区间内
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < nums[mid] && target >= nums[left]) { // 在有序区间内
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

}
