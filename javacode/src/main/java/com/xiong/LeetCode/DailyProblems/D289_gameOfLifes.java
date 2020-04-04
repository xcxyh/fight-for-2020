package com.xiong.LeetCode.DailyProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/2 11:51
 * @description：  289. 生命游戏
 * @modified By：
 * @version: $
 */
public class D289_gameOfLifes {

    public void gameOfLife(int[][] board) {
        if (board.length== 0 || board[0].length == 0){
            return;
        }
        int row = board.length;
        int col = board[0].length;
        //8个方向
        int[][] dir = new int[][]{
                {-1,0},{1,0},{0,1},{0,-1},
                {-1,-1},{-1,1},{1,-1},{1,1}};
        // 利用int 的第二位存储 下一个状态的信息 0bxx 二进制表示 int 数
        for(int i =0;i < row; i++){
            for(int j = 0; j < col; j ++){
                int count = 0; //周围存活细胞数
                for(int[] d : dir){
                    int x = i + d[0];  //  i j  不变 遍历8 个方向
                    int y = j + d[1];
                    if(x >=0 && x < row && y >=0 && y < col){
                        count += board[x][y] & 1;// 之前改变过的位置 要去除第二位上的影响 要 & 1
                    }

                }
                board[i][j] = change(board[i][j] ,count);
            }
        }

        for(int i =0;i < row; i++){
            for(int j = 0; j < col; j ++){
                board[i][j] >>= 1; // 右移一位
            }
        }

    }

    private int change(int curVal, int count){
        if(curVal > 0 && (count < 2 || count > 3)){
            return 0b01; // 二进制用0bxx表示, 八进制用0oxx表示，十六进制用0xxx表示
        }else if (curVal > 0 ){
            return 0b11;
        }else if ( count == 3){
            return 0b10;
        }else{
            return 0b00;
        }

    }
}
