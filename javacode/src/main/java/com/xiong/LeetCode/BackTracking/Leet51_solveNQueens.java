package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/26 18:38
 * @description： 51. N皇后   与 面试题 08.12. 八皇后 是同一题
 * @modified By：
 * @version: $
 */
public class Leet51_solveNQueens {

    private List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {

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
            List<String> list = new ArrayList<>();

            for(char[] line : board){
                list.add(String.valueOf(line));
            }
            ans.add(list);
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
