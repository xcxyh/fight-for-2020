package com.xiong.LeetCode.DailyProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/15 9:33
 * @description：  542. 01 矩阵  可以用 dp  BFS 中的多源广度优先遍历  DFS 来求解
 *
 * 多源广度优先遍历：
 * 一开始将所有0点入队，向四周发散，最先遍历到的1点距离为1，
 * 将这些节点入队，也就是第一层，第0层遍历完毕后，再从队中第一层开始发散，
 * 找到第二层入队，依此类推，直到队中无元素
 * @modified By：
 * @version: $
 */
public class Leet542_01Matrix {

    /**
     *  @author: xiongcong
     *  @Date: 2020/4/15 9:33
     *  @Description:  dp 动态规划的方式
     */
    public int[][] updateMatrix_dp(int[][] matrix) {
        if (matrix == null ){
            return null;
        }
        int[][] dir1 = new int[][]{{-1,0},{0,-1}};//左上方向
        int[][] dir2 = new int[][]{{1,0},{0,1}};//右下方向
        //dp
        //dp[i][j] 表示 位置 i j 上的元素到 0 的最近距离
        //matrix[i][j] == 1  则 dp[i][j] = min(四个方向) + 1
        //matrix[i][j] == 0  则 dp[i][j] == 0
        // 四个方向无法同时遍历到 ，则先判断 左上方向   然后判断  右下方向
        // 即分开遍历， 先正向遍历 ，然后反向遍历
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        //dp 数组初始化
        for(int i =0; i< rows; i++){
            for(int j = 0; j < cols; j++){
                dp[i][j] = 10000;
            }
        }
        // 正向遍历  判断左上方向
        for(int i =0; i< rows; i++){
            for(int j = 0; j < cols; j++){
                if (matrix[i][j] == 1){
                    for(int[] d : dir1){
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x >= 0 && y >=0){
                            dp[i][j] = Math.min(dp[i][j],dp[x][y] + 1);
                        }
                    }
                }else{
                    dp[i][j] = 0;
                }

            }
        }
        // 反向遍历  判断右下方向
        for(int i = rows -1; i >= 0; i--){
            for(int j = cols - 1; j >= 0; j--){
                if (matrix[i][j] == 1){
                    for(int[] d : dir2){
                        int x = i + d[0];
                        int y = j + d[1];
                        if (x < rows && y < cols){
                            dp[i][j] = Math.min(dp[i][j],dp[x][y] + 1);
                        }
                    }
                }else{
                    dp[i][j] = 0;
                }

            }
        }
        return dp;
    }

    //多源广度优先遍历
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return matrix;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] ans = new int[rows][cols];
        Queue<int[]> queue= new LinkedList<>();
        int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        // 所有的0 的位置 入队
        for(int i =0; i< rows; i++){
            for(int j = 0; j< cols; j++){
                if (matrix[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int[] d : dir){
                int x = temp[0] + d[0];
                int y = temp[1] + d[1];

                if (x >=0 && x < rows && y >=0 && y < cols && matrix[x][y] == 1){
                    ans[x][y] = ans[temp[0]][temp[1]] + 1;
                    matrix[x][y] = 0; //visited
                    queue.offer(new int[]{x,y});
                }

            }
        }
        return ans;

    }

}
