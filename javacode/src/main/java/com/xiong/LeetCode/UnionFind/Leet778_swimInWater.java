package com.xiong.LeetCode.UnionFind;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/30 9:52
 * @description： 778. 水位上升的泳池中游泳 Hard    二分 +  并查集  相似题： Leet1631
 * @modified By：
 * @version: $
 */
public class Leet778_swimInWater {

    int N;
    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        N = grid.length;

        int size = N * N;

        int left = 0;
        int right = size - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (havePath(mid, grid, size)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;

    }

    private boolean havePath(int k, int[][] grid, int size) {

        UF uf = new UF(size);

        // i * N + j
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // right down
                if (i < N - 1 && grid[i][j] <= k) {
                    int cost = Math.max(grid[i][j], grid[i + 1][j]);
                    if (cost <= k) {
                        uf.merge(i * N + j, (i + 1) * N + j);
                    }
                }
                if (j < N - 1) {
                    int cost = Math.max(grid[i][j], grid[i][j + 1]);
                    if (cost <= k) {
                        uf.merge(i * N + j, i * N + j + 1);
                    }
                }
            }
        }

        return uf.isConn(0, size - 1);
    }

    class UF {
        int[] f;

        UF (int n) {
            f = new int[n];
            for (int i = 0;i  < n; i++) {
                f[i] = i;
            }
        }

        void merge(int p, int q) {
            int fp = find(p);
            int fq = find(q);

            if (fp != fq) {
                f[fp] = fq;
            }
        }

        boolean isConn(int p ,int q) {
            return find(p) == find(q);
        }

        int find( int x ) {
            while (f[x] != x) {
                f[x] = f[f[x]];
                x = f[x];
            }

            return f[x];
        }
    }
}
