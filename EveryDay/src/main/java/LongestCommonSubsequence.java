import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/9 20:06
 **/
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        LongestCommonSubsequence lsc = new LongestCommonSubsequence();
        String text1 = "abc";
        String text2 = "def";
        System.out.println(lsc.longestCommonSubsequence2(text1, text2, text1.length() - 1, text2.length() - 1));
    }

    public int longestCommonSubsequence2(String text1, String text2, int n, int m) {
        if (m == -1 || n == -1) {
            return 0;
        }
        if (text1.charAt(n) == text2.charAt(m)) {
            return longestCommonSubsequence2(text1, text2, n - 1, m - 1) + 1;
        } else {
            return Math.max(longestCommonSubsequence2(text1, text2, n - 1, m),
                    longestCommonSubsequence2(text1, text2, n, m - 1));
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        // 第一行
        for (int i = 0; i <= text2.length(); i++) {
            dp[0][i] = 0;
        }
        // System.out.println(Arrays.toString(dp[0]));
        // 第一列
        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}
