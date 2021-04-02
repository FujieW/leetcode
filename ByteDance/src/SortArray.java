import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/2 09:14
 **/
public class SortArray {
    public static void main(String[] args) {
        SortArray array = new SortArray();
        System.out.println(Arrays.toString(array.sortArray(new int[]{5, 2, 1, 3, 1, 5})));
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int q = partition(nums, left, right);
        quickSort(nums, left, q);
        quickSort(nums, q + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        int pivot = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;
    }
}
