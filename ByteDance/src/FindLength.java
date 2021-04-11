/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/11 16:34
 **/
public class FindLength {
    public static void main(String[] args) {
        FindLength findLength = new FindLength();
        int[] A = new int[]{1, 2, 3, 2, 1};
        int[] B = new int[]{3, 2, 1, 4, 7};
        System.out.println(findLength.findLength(A, B));
    }

    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }


}
