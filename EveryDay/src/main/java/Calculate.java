import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/10 16:02
 **/
public class Calculate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int step = sc.nextInt();
        char[][] board = new char[m][n];
        String c = sc.nextLine(); // 接收回车
        // 输入棋盘
        for (int i = 0; i < m; i++) {
            String temp = sc.nextLine();
            for (int j = 0; j < temp.length(); j++) {
                board[i][j] = temp.charAt(j);
            }
        }
        // debug 棋盘
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        // 输入 方向
        String[] directions = new String[step];
        for (int i = 0; i < step; i++) {
            String direction = sc.nextLine();
            directions[i] = direction;
        }
        // debug 方向
        System.out.println(Arrays.toString(directions));
        System.out.println(Arrays.toString(getEndPoint(board, m, n, directions)));

    }

    public static int[] getEndPoint(char[][] board, int m, int n, String[] directions) {
        int x = 0, y = 0;
        // 找起点
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '@') {
                    x = i;
                    y = j;
                }
            }
        }
        for (String direction : directions) {
            if ("EAST".equals(direction)) {
                // y 坐标右移
                for (int i = y; i < board[0].length && board[x][i] != '#'; i++) {
                    y++;
                }
                // 走过头
                if (y == board[0].length || board[x][y] == '#') {
                    y--;
                }
            } else if ("WEST".equals(direction)) {
                // y 坐标左移
                for (int i = y; i >= 0 && board[x][i] != '#'; i--) {
                    y--;
                }
                if (y == -1 || board[x][y] == '#') {
                    y++;
                }
            } else if ("NORTH".equals(direction)) {
                // x 坐标上移
                for (int i = x; i >= 0 && board[i][y] != '#'; i--) {
                    x--;
                }
                if (x == -1 || board[x][y] == '#') {
                    x = 0;
                }
            } else if ("SOUTH".equals(direction)) {
                // x 坐标下移
                for (int i = x; i < board.length && board[i][y] != '#'; i++) {
                    x++;
                }
                if (x == board.length || board[x][y] == '#') {
                    x--;
                }
            } else {
                System.out.println("direction is error");
            }
            System.out.printf("[%d, %d]\n", x, y);
        }
        return new int[]{x + 1, y + 1};
    }

    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}
