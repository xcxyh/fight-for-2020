package com.xiong.LeetCode.DailyProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/26 16:06
 * @description： 329. 矩阵中的最长递增路径
 * @modified By：
 * @version: $
 */
public class Leet329_longestIncreasingPath {

    private int[][] memo;
    private int[][] dirs =new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private int m;
    private int n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        m = matrix.length;
        n = matrix[0].length;

        memo = new int[m][n];
        int max = 0;
        for(int i = 0; i< m; ++i){
            for(int  j = 0; j < n; ++j){
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }
    // 从一个点开始深度搜索， 找出 以此为起点的 最长 递增路径长度
    // 使用 memo 记录，避免重复搜索
    private int dfs(int[][] matrix, int i , int j){
        if (memo[i][j] != 0){
            return memo[i][j];
        }

        // 遍历 该点的 四个方向，找到最大的那个，赋给 memo[i][j]
        for(int[] d : dirs){
            int x = i + d[0];
            int y = j + d[1];

            if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]){
                memo[i][j] = Math.max(memo[i][j] , dfs(matrix, x, y));
            }
        }
        // 本身点的长度 为 1
        ++memo[i][j];

        return memo[i][j];
    }

}
