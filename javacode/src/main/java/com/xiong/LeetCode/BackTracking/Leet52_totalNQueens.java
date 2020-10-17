package com.xiong.LeetCode.BackTracking;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/10/17 10:45
 * @description：  52. N皇后 II
 * @modified By：
 * @version: $
 */
public class Leet52_totalNQueens {

    private int ans = 0;
    public int totalNQueens(int n) {

        // 生成board
        char[][] board = new char[n][n];
        //init
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        //回溯得到所有的情况，然后根据规则进行剪枝
        backtracking(n, board, 0);
        return ans;
    }

    private void backtracking(int n,char[][] board,int row){

        if (row == n){
            ans++;
            return;
        }

        for(int j = 0; j < n; j++){
            // 检查
            if (check(board, row, j)){
                board[row][j] = 'Q';
                backtracking(n, board, row + 1);
                board[row][j] = '.';
            }
        }

    }
    // 检查 当前 Queen 的放置是否 合法
    private boolean check(char[][] board, int row, int col){
        // 不在同一列上
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // 不在同一行上
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 'Q') return false;
        }
        // 不在 同一对角线上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // 不在 同一反对角线上
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
