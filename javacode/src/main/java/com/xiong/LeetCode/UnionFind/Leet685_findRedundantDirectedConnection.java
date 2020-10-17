package com.xiong.LeetCode.UnionFind;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/17 11:25
 * @description： 685. 冗余连接 II  HARD 有向图中附加边问题
 * @modified By：
 * @version: $
 */
public class Leet685_findRedundantDirectedConnection {

    //？？
    public int[] findRedundantDirectedConnection(int[][] edges) {

        int nodesCount = edges.length;
        UF uf = new UF(nodesCount + 1);
        int[] parent = new int[nodesCount + 1];
        for (int i = 1; i <= nodesCount; ++i) {
            parent[i] = i;
        }
        int conflict = -1;
        int cycle = -1;
        for (int i = 0; i < nodesCount; ++i) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                if (uf.find(node1) == uf.find(node2)) {
                    cycle = i;
                } else {
                    uf.union(node1, node2);
                }
            }
        }
        if (conflict < 0) {
            int[] redundant = {edges[cycle][0], edges[cycle][1]};
            return redundant;
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                int[] redundant = {parent[conflictEdge[1]], conflictEdge[1]};
                return redundant;
            } else {
                int[] redundant = {conflictEdge[0], conflictEdge[1]};
                return redundant;
            }
        }
    }

    class UF{
        int[] parents;
        int count;

        UF (int n) {
            parents = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parents[i] =i;
            }
        }

        public void union(int p, int q){
            int fp = find(p);
            int fq = find(q);

            if (fp != fq) {
                count--;
                parents[fq] = fp;
            }
        }

        public boolean connected(int p, int q){
            int fp = find(p);
            int fq = find(q);

            return fp == fq;
        }

        public int count(){
            return count;
        }

        private int find(int x) {
            while(x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }
    }
}
