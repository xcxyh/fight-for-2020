package com.xiong.LeetCode.DFSandBFS;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/16 9:17
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet733_floodfill {
    private int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }

        int rows = image.length;
        int cols = image[0].length;
        dfs(image, sr, sc, newColor, image[sr][sc], new boolean[rows][cols]);
        return image;

    }

    private void dfs(int[][] image, int i, int j, int newColor, int rawColor, boolean[][] visited) {

        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length) {
            return;
        }

        if (visited[i][j]) {
            return;
        }

        if (image[i][j] != rawColor) {
            return;
        }

        // 变色
        image[i][j] = newColor;
        visited[i][j] = true;

        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];

            dfs(image, x, y, newColor, rawColor, visited);
        }


    }
}
