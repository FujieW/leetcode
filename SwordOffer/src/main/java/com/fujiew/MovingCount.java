package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/3 13:43
 **/
public class MovingCount {
    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        System.out.println(movingCount.movingCount(3, 2, 1));
    }

    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        System.out.println(visited[0][0]);

        return reachable(0, 0, m, n, k, visited);
    }

    private int reachable(int i, int j, int m, int n, int k, int[][] visited) {
        // 越界
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == 1) {
            return 0;
        }

        if (getNum(i) + getNum(j) <= k) {
            visited[i][j] = 1;
            return 1 + reachable(i + 1, j, m, n, k, visited) +
                    reachable(i, j + 1, m, n, k, visited);
        } else {
            // 超过k
            return 0;
        }
    }

    private int getNum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += (num % 10);
            num /= 10;
        }
        return sum;
    }
}
