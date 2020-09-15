package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/15 12:27
 * @description： 剑指 Offer 12. 矩阵中的路径  回溯 dfs   专业模板
 * @modified By：
 * @version: $
 */
public class J12_exist {

    private int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    private  int rows;
    private int cols;
    public boolean exist(char[][] board, String word) {

        rows = board.length;
        cols = board[0].length;

        char first = word.charAt(0);

        boolean flag = false;

        for (int i = 0; i< rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (first == board[i][j]) {
                    board[i][j] = '#';
                    flag = flag || dfs(board, i, j, 1, word);
                    board[i][j] = first;
                }
            }
        }

        return flag;
    }

    private boolean dfs(char[][] board, int i, int j, int cur,  String word){

        if (cur == word.length()) {
            return true;
        }

        boolean ret = false;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (inArea(x, y) && cur < word.length() && board[x][y] == word.charAt(cur)) {
                char temp =  board[i][j];
                board[i][j] = '#';
                ret = ret || dfs(board, x, y, cur+ 1, word);
                board[i][j] =  temp;
            }
        }

        return ret;

    }

    private boolean inArea(int i, int j){
        return !(i < 0 || i >= rows || j < 0 || j >= cols);
    }

}
