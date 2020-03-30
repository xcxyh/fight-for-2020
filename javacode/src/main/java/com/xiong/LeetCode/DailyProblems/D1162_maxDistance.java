package com.xiong.LeetCode.DailyProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/29 9:56
 * @description：   不想做这题
 * @modified By：
 * @version: $
 */
public class D1162_maxDistance {

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
    }

    public static int maxDistance(int[][] grid) {

    return 0;

    }




    /**
     *  @author: xiongcong
     *  @Date: 2020/3/29 15:40
     *  @Description: 超时
     */
    public static int maxDistance_wrong(int[][] grid) {
        if (grid.length == 1 || grid[0].length == 1) {
            return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int max = -1;
        boolean[][]  isVisited = new boolean[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] temp = queue.poll();
                        int x = temp[0];
                        int y = temp[1];
                        for (int[] d : dir) {
                            int nx = x + d[0];
                            int ny = y + d[1];
                            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length ) {

                                if (grid[nx][ny] == 1) {
                                    max = Math.max(max, Math.abs(nx - i) + Math.abs(ny - j));
                                    queue.clear();
                                    break;
                                } else {
                                    queue.offer(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
}
