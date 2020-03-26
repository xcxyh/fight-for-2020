package com.xiong.LeetCode.DailyProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/26 9:45
 * @description： 999. 车的可用捕获量
 * @modified By：
 * @version: $
 */
public class D999_numRookCaptures {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        //遍历找到R
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    int x = i;
                    int y = j;
                    //然后尝试四个方向  返回结果
                    //上
                    while (x >= 0 && board[x][y] != 'B') {
                        if (board[x][y] == 'p') {
                            count++;
                            break;
                        }
                        x--;
                    }
                    x=i;//复位
                    //下
                    while (x < board.length && board[x][y] != 'B') {
                        if (board[x][y] == 'p') {
                            count++;
                            break;
                        }
                        x++;
                    }
                    x=i;
                    //左
                    while (y >=0 && board[x][y] != 'B') {
                        if (board[x][y] == 'p') {
                            count++;
                            break;
                        }
                        y--;
                    }
                    y=j;
                    //右
                    while (y < board[0].length && board[x][y] != 'B') {
                        if (board[x][y] == 'p') {
                            count++;
                            break;
                        }
                        y++;
                    }
                }
            }
        }
        return count;
    }

}
