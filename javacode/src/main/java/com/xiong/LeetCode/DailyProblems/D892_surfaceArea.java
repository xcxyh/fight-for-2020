package com.xiong.LeetCode.DailyProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/25 16:43
 * @description： 892. 三维形体的表面积
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。
 * @modified By：
 * @version: $
 */
public class D892_surfaceArea {
    public int surfaceArea(int[][] grid) {
        if(grid == null || grid.length ==0 || grid[0].length==0){
            return 0;
        }
        int count = 0;
        int cover = 0;
        //遍历二维数组  统计总的面积 - 被盖住的面积
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //先统计单个格子上的 总面积
                count += grid[i][j] == 0 ? 0 : 2 + 4 * grid[i][j];
                //然后统计相邻之间的被盖住的面积
                //统计与当前格子相邻的  右格子和下格子即可
                if (j + 1 < grid[0].length ) { //矮的那个决定盖住面积
                    cover += grid[i][j + 1] > grid[i][j] ? grid[i][j] * 2 : grid[i][j + 1] * 2;
                }
                if (i +1 < grid.length) {
                    cover += grid[i + 1][j] > grid[i][j] ? grid[i][j] * 2 : grid[i + 1][j] * 2;
                }
            }
        }
        return count - cover;
    }
}
