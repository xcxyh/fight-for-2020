package com.xiong.LeetCode.UnionFind;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/11 10:35
 * @description： 130. 被围绕的区域
 * @modified By：
 * @version: $
 */
public class Leet130_solve {

    int rows;
    int cols;
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return;
        }

        rows = board.length;
        cols = board[0].length;

        // 1 dfs 所有边界上的 o ，变成 其他字符
        for(int i = 0; i < rows; i++){
            // 第一列 和最后一列
            if (board[i][0] == 'O'){
                dfs(board, i, 0);
            }
            if (board[i][cols - 1] == 'O'){
                dfs(board, i, cols - 1);
            }
        }
        for(int j = 0; j < cols; j++){
            // 第一行 和最后一行
            if (board[0][j] == 'O'){
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O'){
                dfs(board, rows - 1, j);
            }
        }
        // 2 将 剩余的 o 变成 x
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (board[i][j] == 'O'){
                    board[i][j]= 'X';
                }
            }
        }
        // 3 将其他字符变回 为 o
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if (board[i][j] == '#'){
                    board[i][j]= 'O';
                }
            }
        }

    }

    private void dfs(char[][] board, int i, int j){

        board[i][j] = '#';

        for(int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];

            if (x >=0 && y >= 0 && x < rows && y < cols && board[x][y] == 'O'){
                dfs(board, x, y);
            }
        }
    }
}
