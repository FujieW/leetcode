import java.util.Arrays;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/2 15:08
 **/
public class NumMatrix {

    private int[][] sums = null;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {

            sums = new int[matrix.length][matrix[0].length + 1];
            for (int i = 0; i < matrix.length; i++) { // 行
                sums[i][0] = 0;
                for (int j = 1; j <= matrix[0].length; j++) { // 列
                    sums[i][j] = sums[i][j-1] + matrix[i][j-1];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            System.out.println(sum);
            sum += this.sums[i][col2+1] - this.sums[i][col1];
        }
        return sum;
    }
}
