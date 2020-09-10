package com.xiong.LeetCode.DFSandBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/20 11:10
 * @description： 200. 岛屿数量  DFS  或者是 BFS  都可以解
 * @modified By：
 * @version: $
 */
public class Leet200_numIslands {

    //DFS 深度优先遍历   DFS 要比 BFS 快一点
    private int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands_dfs(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int ans = 0;
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == '1'){
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    private void dfs(char[][] grid, int i, int j){
        grid[i][j] = '0'; // 置为0 表示走过了

        //遍历当前点的四个方向
        for(int[] d : dir){
            int x = i + d[0];
            int y = j + d[1];

            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1'){
                dfs(grid,x,y);
            }

        }
    }


    //BFS  广度优先遍历  对每一个还为 1 的点 进行BFS ， 添加进了为queue 则 置为 0 表示走过了
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        int[][] dir = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '0'){
                    continue;
                }
                ans++;
                queue.offer(new int[]{i,j});
                while(!queue.isEmpty()){
                    int[] temp = queue.poll();
                    for(int[] d : dir){
                        int x = temp[0] + d[0];
                        int y = temp[1] + d[1];
                        if(x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1'){
                            queue.offer(new int[]{x,y});
                            grid[x][y] = '0';
                        }
                    }
                }
            }
        }
        return ans;
    }


}
