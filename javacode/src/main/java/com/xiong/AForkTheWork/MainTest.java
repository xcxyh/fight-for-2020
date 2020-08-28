package com.xiong.AForkTheWork;

import com.xiong.LeetCode.TreeNode;
import com.xiong.ListNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/21 12:56
 * @description：  主要测试类
 * @modified By：
 * @version: $
 */
public class MainTest {
    public static void main(String[] args){
        //round() ：返回四舍五入，负 .5 小数返回较大整数，如 -1.5 返回 -1。
        //   四舍五入的原理是在参数上加0.5然后做向下取整。  例  -1.6 +0.5 = -1.1 向下取整 为 -2
        //ceil() ：返回小数所在两整数间的较大值，如 -1.5 返回 -1。
        //floor() ：返回小数所在两整数间的较小值，如 -1.5 返回 -2。
        //floor就是取地板，ceil取天花板，round的实现即时 +0.5然后计算floor
        System.out.println(Math.round(1.5));  //  2 四舍五入
        System.out.println(Math.round(-1.5));  //  -1 四舍五入

    }

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
        }

        dfs(board, click[0], click[1]);

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


    public static boolean Game24Points (int[] arr) {
        return Point24(arr, 0, 0);
    }

    private static boolean Point24(int[] arr, int i, int res) {
        if(res == 24) return true;

        if (i < 4) {
            return Point24(arr, i + 1, res + arr[i])
                    || Point24(arr, i + 1, res - arr[i])
                    || Point24(arr, i + 1, res == 0 ? 0 : res * arr[i])
                    || Point24(arr, i + 1, res == 0 ? 0 : res / arr[i]);
        } else
            return false;
    }

}
