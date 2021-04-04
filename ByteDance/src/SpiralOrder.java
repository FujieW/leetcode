import java.util.ArrayList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/4/4 11:22
 **/
public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder order = new SpiralOrder();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(order.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int top = 0;
        int right = col - 1;
        int bottom = row - 1;
        List<Integer> res = new ArrayList<>();
        while (left <= right && top <= bottom) {
            // 从左向右
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            // 往下移一行
            if (top + 1 > bottom) {
                break;
            } else {
                top++;
            }
            // 从上往下遍历
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            // 向左移一列
            if (right - 1 < left) {
                break;
            } else {
                right--;
            }
            // 从右向左遍历
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            // 向上移一行
            if (bottom - 1 < top) {
                break;
            } else {
                bottom--;
            }
            // 从下往上遍历
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            // 向右移一列
            if (left + 1 > right) {
                break;
            } else {
                left++;
            }
        }
        return res;
    }
}
