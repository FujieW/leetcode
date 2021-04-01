/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/1 11:05
 **/
public class FindKthLargest {
    public static void main(String[] args) {
        FindKthLargest largest = new FindKthLargest();
        System.out.println(largest.findKthLargest(new int[]{2,1}, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int index = partition(nums, left, right);
            if (index == k - 1) {
                return nums[index];
            } else if (index > k - 1) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }
        return nums[0];
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];

        while (left < right) {
            // 从右向左
            while (left < right && nums[right] <= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] >= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }
}
