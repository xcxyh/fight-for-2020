package com.xiong.LeetCode.DFSandBFS;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/20 11:15
 * @description： 529. 扫雷游戏  floodfill 的应用
 * @modified By：
 * @version: $
 */
public class Leet529_updateBoard {

    private int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1},
            {-1,-1},{1,-1},{1,1},{-1,1}};

    private int rows;
    private int cols;
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || board[0].length == 0){
            return board;
        }
        rows = board.length;
        cols = board[0].length;

        if (board[click[0]][click[1]] == 'M'){
            board[click[0]][click[1]] = 'X';
        }else{
            dfs(board, click[0], click[1]);
        }

        return board;
    }

    private void dfs(char[][] board, int i , int j){

        // 先统计周围的 雷的情况
        int cnt = 0;
        for(int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];
            if (x >= rows || x < 0 || y >= cols || y < 0){
                continue;
            }
            if (board[x][y] == 'M'){
                cnt++;
            }
        }

        if (cnt == 0){
            // 只有当 周围 都没有雷 才继续 dfs
            board[i][j] = 'B';
            for(int[] d : dir){
                int x = i + d[0];
                int y = j + d[1];
                if (x >= rows || x < 0 || y >= cols || y < 0 || board[x][y] != 'E'){
                    continue;
                }
                dfs(board, x, y);
            }

        }else{
            board[i][j] = (char)(cnt + '0');
        }
    }



}
