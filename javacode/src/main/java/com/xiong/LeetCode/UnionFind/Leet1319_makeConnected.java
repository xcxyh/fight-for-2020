package com.xiong.LeetCode.UnionFind;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/23 10:51
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1319_makeConnected {

    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }

        UF uf = new UF(n);

        for(int[] conn : connections) {
            uf.union(conn[0], conn[1]);
        }

        return uf.count() - 1;

    }

    class UF {
        int[] f;
        int count;

        UF(int n) {
            f = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        boolean union(int p, int q) {
            int fp = find(p);
            int fq = find(q);
            if (fp != fq) {

                f[fp] = fq;
                count--;
                return true;
            }

            return false;
        }

        int find(int x) {
            while (f[x] != x) {
                f[x] = f[f[x]];
                x = f[x];
            }

            return f[x];
        }

        int count() {
            return count;
        }

    }

}
