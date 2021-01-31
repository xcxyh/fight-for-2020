package com.xiong.LeetCode.UnionFind;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/25 10:30
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet959_regionsBySlashes {

    private int count;
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[] f = new int[n * n * 4];
        count = n * n * 4;
        for (int i = 0; i < n * n * 4; i++) {
            f[i] = i;
        }
        // 1 *1 方格中 分成四个区域，  上 0  右 1 下 2 左 3
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int idx = i * n + j;
                if (i < n - 1) {
                    int bottom = idx + n;
                    merge(f, idx * 4 + 2, bottom * 4);
                }
                if (j < n - 1) {
                    int right = idx + 1;
                    merge(f, idx * 4 + 1, right * 4 + 3);
                }
                if (grid[i].charAt(j) == '/') {
                    merge(f, idx * 4, idx * 4 + 3);
                    merge(f, idx * 4 + 1, idx * 4 + 2);
                } else if (grid[i].charAt(j) == '\\') {
                    merge(f, idx * 4, idx * 4 + 1);
                    merge(f, idx * 4 + 2, idx * 4 + 3);
                } else {
                    merge(f, idx * 4, idx * 4 + 1);
                    merge(f, idx * 4 + 1, idx * 4 + 2);
                    merge(f, idx * 4 + 2, idx * 4 + 3);
                }
            }
        }

        return count;
    }

    public int find(int[] f, int x) {
        if (f[x] == x) {
            return x;
        }
        int fa = find(f, f[x]);
        f[x] = fa;
        return fa;
    }

    public void merge(int[] f, int p, int q) {
        int fp = find(f, p);
        int fq = find(f, q);


        if (fp != fq) {
            f[fp] = fq;
            count--;
        }

    }
}
