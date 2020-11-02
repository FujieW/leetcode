package com.fujiew;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/2 17:17
 **/
public class Exist {
    public static void main(String[] args) {

    }

    /**
     * 深度优先搜索
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] paths = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existPath(board, i, j, paths, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean existPath(char[][] board, int i, int j, char[] paths, int k) {
        if (i < 0 || j >= board[0].length || i >= board.length || j < 0 || board[i][j] != paths[k]) {
            return false;
        }
        if (k == paths.length - 1) {
            return true;
        }
        char temp = board[i][j];
        board[i][j] = '-';
        boolean flag = existPath(board, i - 1, j, paths, k + 1) || existPath(board, i + 1, j, paths, k + 1)
                || existPath(board, i, j - 1, paths, k + 1) || existPath(board, i, j + 1, paths, k + 1);
        board[i][j] = temp;
        return flag;
    }
}
