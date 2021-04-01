/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/1 09:36
 **/
public class Trap {
    public static void main(String[] args) {

    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int ans = 0;
        int left = 0;
        int right = n - 1;
        int lMax = height[0];
        int rMax = height[n - 1];
        while (left <= right) {
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);

            if (lMax < rMax) {
                ans += lMax - height[left];
                left++;
            } else {
                ans += rMax - height[right];
                right--;
            }
        }
        return ans;
    }

}
