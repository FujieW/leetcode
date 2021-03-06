/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/3 10:21
 **/
public class Merge {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[len--] = nums1[i--];
            } else {
                nums1[len--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[len--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[len--] = nums2[j--];
        }
    }
}
