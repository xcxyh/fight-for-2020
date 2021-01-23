package com.xiong.LeetCode.UnionFind;

import com.xiong.LeetCode.Solution;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/19 10:03
 * @description： 1584. 连接所有点的最小费用  最小生成树：Kruskal算法（需借助并查集）或者 Prim算法
 * @modified By：
 * @version: $
 */
public class Leet1584_minCostConnectPoints {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        // 点 边 式
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = calcuDist(points[i], points[j]);
                edges.add(new int[]{dist, i, j});
            }
        }

        int ans = 0;
        // 排序
        edges.sort(Comparator.comparingInt(a -> a[0])); //(a,b) -> (a[0] - b[0])
        UF uf = new UF(n);
        for (int[] edge : edges) {
            if (!uf.isConnected(edge[1], edge[2])) {
                uf.merge(edge[1], edge[2]);
                ans += edge[0];
            }
        }

        return ans;


    }

    private int calcuDist(int[] p1, int[] p2){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    class UF {
        int[] f;

        UF(int n) {
            f = new int[n];
            for (int i = 0;i < n; i++) {
                f[i] = i;
            }
        }

        boolean isConnected(int p ,int q) {
            return find(p) == find(q);
        }
        void merge(int p ,int q) {
            int fp = find(p);
            int fq = find(q);

            if (fp != fq) {
                f[fp] = fq;
            }
        }

        int find(int x) {
            while (f[x] != x) {
                f[x] = f[f[x]];
                x = f[x];
            }
            return f[x];
        }
    }
}
