package com.xiong.LeetCode.UnionFind;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/27 11:09
 * @description：  1579. 保证图可完全遍历  Hard
 * @modified By：
 * @version: $
 */
public class Leet1579_maxNumEdgesToRemove {


    public int maxNumEdgesToRemove(int n, int[][] edges) {

        UF uf1 = new UF(n + 1);
        UF uf2 = new UF(n + 1);
        // 编号从 1 开始 ，先把 0 和 1 连接
        uf1.union(0, 1);
        uf2.union(0, 1);
        int ans = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                // type3 里面 多余的边 只计算一次
                if (!uf1.union(edge[1], edge[2])){
                    ans++;
                }
                uf2.union(edge[1], edge[2]);
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                // type1 里面 多余的边
                if (!uf1.union(edge[1], edge[2])){
                    ans++;
                }
            }

            if (edge[0] == 2) {
                // type2 里面 多余的边
                if (!uf2.union(edge[1], edge[2])){
                    ans++;
                }
            }
        }

        if (uf1.count() > 1 || uf2.count() > 1) {
            return -1;
        }

        return ans;

    }

    class UF {

        int[] f;
        int count;

        UF (int n) {
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


        int find( int x) {
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
