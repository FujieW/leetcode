/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/9 21:02
 **/
public class MinDistance {
    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        String word1 = "rad";
        String word2 = "apple";
        // System.out.println(minDistance.minDistance(word1, word2));
        System.out.println(minDistance.minDistance(word1, word2));

    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        return minDistance(word1, word2, word1.length() - 1, word2.length() - 1, dp);
    }

    public int minDistance(String word1, String word2, int n, int m, int[][] dp) {

        if (n == -1) {
            return m + 1;
        }
        if (m == -1) {
            return n + 1;
        }
        if (dp[n][m] != 0) {
            return dp[n][m];
        }
        if (word1.charAt(n) == word2.charAt(m)) {
            dp[n][m] = minDistance(word1, word2, n - 1, m - 1, dp);
        } else {
            dp[n][m] = Math.min(minDistance(word1, word2, n - 1, m - 1, dp) + 1,
                    Math.min(minDistance(word1, word2, n - 1, m, dp) + 1, minDistance(word1, word2, n, m - 1, dp) + 1));
        }
        return dp[n][m];
    }
    /*public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 第一行
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = i;
        }
        // 第一列
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }*/
}
