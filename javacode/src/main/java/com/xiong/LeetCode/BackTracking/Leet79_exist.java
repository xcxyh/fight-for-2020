package com.xiong.LeetCode.BackTracking;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/8 9:57
 * @description： 79. 单词搜索
 * @modified By：
 * @version: $
 */
public class Leet79_exist {

    private int rows;
    private int cols;
    private int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {

        rows = board.length;
        cols = board[0].length;
        boolean ans = false;
        char first = word.charAt(0);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (first == board[i][j]) {
                    board[i][j] = '#';
                    ans = ans || dfs(board, word, 1, i, j);
                    board[i][j] = first;
                }
            }
        }
        return ans;
    }

    private boolean dfs(char[][] board, String word, int cur, int i, int j) {

        if (cur == word.length()) {
            return true;
        }
        boolean ret = false;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && y >= 0 && x < rows && y < cols && board[x][y] == word.charAt(cur)) {
                char t = board[x][y];
                board[x][y] = '#';
                ret = ret || dfs(board, word, cur + 1, x, y);
                board[x][y] = t;
            }
        }

        return ret;
    }
}
