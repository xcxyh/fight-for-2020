package com.xiong.LeetCode.DFSandBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/11/17 10:36
 * @description： 1030. 距离顺序排列矩阵单元格
 * @modified By：
 * @version: $
 */
public class Leet1030_allCellsDistOrder {

    // bfs
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {


        List<int[]> list = new ArrayList<>();

        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        boolean[][] visited = new boolean[R][C];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{r0, c0});
        visited[r0][c0] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            list.add(cur);

            for (int[] d : dir){
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                if ( x >= 0 && y >= 0 && x < R && y < C && !visited[x][y]){
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
        }

        return list.toArray(new int[R * C][2]);
    }
}
