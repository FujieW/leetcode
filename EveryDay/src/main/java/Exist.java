/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/29 14:28
 **/
public class Exist {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        Exist exist = new Exist();
        System.out.println(exist.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, chs, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, char[] chs, int index) {
        // 结束条件
        if (index == chs.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != chs[index]) {
            return false;
        }
        // 做选择
        char temp = board[i][j];
        board[i][j] = '*';
        boolean flag = dfs(board, i - 1, j, chs, index + 1) ||
                dfs(board, i + 1, j, chs, index + 1) ||
                dfs(board, i, j - 1, chs, index + 1) ||
                dfs(board, i, j + 1, chs, index + 1);
        board[i][j] = temp;
        return flag;
    }
}
