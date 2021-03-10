import java.util.*;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/4 15:19
 **/
public class MaxEnvelopes {
    public static void main(String[] args) {
        int[][] envelopes = new int[][]{{46,89},{50,53},{52,68},{72,45},{77,81}};
        MaxEnvelopes maxEnvelopes = new MaxEnvelopes();
        System.out.println(maxEnvelopes.maxEnvelopes(envelopes));
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int[] arr = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            System.out.println(envelopes[i][0] + " " + envelopes[i][1]);
            arr[i] = envelopes[i][1];
        }
        System.out.println(Arrays.toString(arr));
        return lengthOfLIS(arr);

    }
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxLength = 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
