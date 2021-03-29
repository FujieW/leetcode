/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/11 09:42
 **/
public class Package {
    public static void main(String[] args) {
        Package p = new Package();
        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        System.out.println("p.kanpsack(4,3,wt, val) = " + p.kanpsack(4, 3, wt, val));
    }

    public int kanpsack(int w, int n, int[] wt, int[] val) {
        int[][] dp = new int[n + 1][w + 1];
        // 背包所剩空间为0
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        // 没有物品得时候
        for (int i = 0; i < w + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                // 背包装不下当前物品
                if (j - wt[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                // 能装进
                else {
                    dp[i][j] = Math.max(dp[i - 1][j - wt[i - 1]] + val[i - 1], // 装进
                            dp[i - 1][j]); // 不装
                }
            }
        }
        return dp[n][w];
    }
}
