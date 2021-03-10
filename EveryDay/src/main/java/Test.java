import common.ListNode;
import common.TreeNode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/29 14:22
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String c = sc.nextLine(); // 接收回车
        for (int i = 0; i < n; i++) {
            String num = sc.nextLine();
            System.out.println(num);
        }

    }

    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }
        if (x == -1) {
            return (n & 1) == 0 ? 1 : -1;
        }
        if (n < 0) {
            return 1 / x * myPow(1 / x, -n - 1);
        }
        return myPow(x * x, n >> 1) * (((n & 1) == 0) ? 1 : x);
    }

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }

    public int cuttingRope(int n) {
        if (n < 3) {
            return n - 1;
        }
        int res = 1;
        while (n > 4) {
            n -= 3;
            res *= 3;
        }
        return res * n;
    }

    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        return movingCount(n, n, k, visited, 0, 0);
    }

    private int movingCount(int m, int n, int k, int[][] visited, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == 1) {
            return 0;
        }
        int count = 0;
        if (getNum(i) + getNum(j) <= k) {
            visited[i][j] = 1;
            count += 1 + movingCount(m, n, k, visited, i + 1, j) + movingCount(m, n, k, visited, i, j + 1);
        }
        return count;
    }

    private int getNum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int k) {
        if (i < 0 || i >= board.length || j < 0 || j > board[0].length || board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '-';
        boolean flag = exist(board, i, j + 1, word, k + 1) || exist(board, i - 1, j, word, k + 1)
                || exist(board, i, j + 1, word, k + 1) || exist(board, i, j - 1, word, k + 1);
        board[i][j] = temp;
        return flag;
    }
}
