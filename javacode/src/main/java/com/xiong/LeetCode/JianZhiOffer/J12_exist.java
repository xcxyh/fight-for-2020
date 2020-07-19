package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/15 12:27
 * @description： 剑指 Offer 12. 矩阵中的路径  回溯 dfs  恶心 错了好几次
 * @modified By：
 * @version: $
 */
public class J12_exist {

    public boolean exist(char[][] board, String word) {

        if (word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int cur, int i, int j) {

        int rows = board.length;
        int cols = board[0].length;

        if (cur == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != word.charAt(cur)) {
            return false;
        }


        boolean res = false;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        char temp = board[i][j];
        // 回溯
        board[i][j] = '$';
        for (int[] d : dir) {
            int x = d[0] + i;
            int y = d[1] + j;
            res = res || dfs(board, word, cur + 1, x, y);
        }
        board[i][j] = temp;

        return res;

    }
}
