import java.util.ArrayList;
import java.util.List;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/15 15:49
 **/
public class SpiralOrder {
    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}};
        System.out.println(spiralOrder.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int col = matrix[0].length;
        int row = matrix.length;
        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;
        while (true) {
            // 向右
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            // 缩小上边界
            if (top + 1 > bottom) {
                break;
            } else {
                top++;
            }
            // 向下移动
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            // 缩小右边界
            if (right - 1 < left) {
                break;
            } else {
                right--;
            }
            // 向左移动
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            // 缩小下边界
            if (bottom - 1 < top) {
                break;
            } else {
                bottom--;
            }
            // 向上移动
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            // 缩小左边界
            if (left + 1 > right) {
                break;
            } else {
                left++;
            }
        }
        return list;
    }
}
