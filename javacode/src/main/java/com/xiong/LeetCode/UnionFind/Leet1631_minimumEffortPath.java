package com.xiong.LeetCode.UnionFind;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/29 15:25
 * @description：    1631. 最小体力消耗路径   二分 +  并查集  不难   与 leet778 一样的写法
 * @modified By：
 * @version: $
 */
public class Leet1631_minimumEffortPath {

    int row;
    int col;
    public int minimumEffortPath(int[][] heights) {

        row = heights.length;
        col = heights[0].length;
        int size = row * col;
        // i * col + j

        // find max val
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // right down
                if (i < row - 1) {
                    max = Math.max(max, Math.abs(heights[i][j] - heights[i + 1][j]));
                }
                if (j < col - 1) {
                    max = Math.max(max, Math.abs(heights[i][j] - heights[i][j + 1]));
                }
            }
        }

        // binary search + unionfind
        int left = 0;
        int right = max;
        while(left < right) {
            int mid = left + (right - left) /2;
            if (havePath(mid, size, heights)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;

    }

    private boolean havePath(int k, int size, int[][] heights) {
        UF uf = new UF(size);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // right down
                if (i < row - 1) {
                    int cost = Math.abs(heights[i][j] - heights[i + 1][j]);
                    if (cost <= k) {
                        uf.merge(i * col + j, (i + 1) * col + j);
                    }
                }
                if (j < col - 1) {
                    int cost = Math.abs(heights[i][j] - heights[i][j + 1]);
                    if (cost <= k) {
                        uf.merge(i * col + j, i * col + j + 1);
                    }
                }
            }
        }

        return uf.isConn(0, size - 1);

    }


    class UF {
        int[] f;

        UF(int n) {
            f = new int[n];
            for (int i = 0; i< n; i++) {
                f[i] = i;
            }

        }

        boolean isConn(int p , int q) {
            return find(p) == find(q);
        }

        void merge(int p, int q) {
            int fp = find(p);
            int fq = find(q);

            if (fp != fq) {
                f[fp] =fq;
            }
        }

        int find(int x) {
            while(x != f[x]) {
                f[x] = f[f[x]];
                x = f[x];
            }
            return f[x];
        }

    }
}
