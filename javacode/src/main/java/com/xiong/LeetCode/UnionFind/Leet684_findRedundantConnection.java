package com.xiong.LeetCode.UnionFind;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/17 10:45
 * @description：   684. 冗余连接   并查集 应用
 * @modified By：
 * @version: $
 */
public class Leet684_findRedundantConnection {


    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        int[] f= new int[n + 1];

        for (int i = 0;i < n; i++) {
            f[i] = i;
        }

        for (int[] edge : edges) {
            int p = edge[0];
            int q = edge[1];
            int fp = find(f, p);
            int fq = find(f, q);
            if (fp != fq) {
                f[fp] = fq;
            } else {
                return edge;
            }
        }

        return new int[]{};
    }

    private int find(int[] f, int x) {
        while (f[x] != x) {
            f[x] = f[f[x]];
            x = f[x];
        }

        return f[x];
    }


    public int[] findRedundantConnection1(int[][] edges) {


        int n = edges.length;

        UF  uf = new UF(n + 1);

        for (int i = 0; i < n; i ++) {
            int p = edges[i][0];
            int q = edges[i][1];

            if (!uf.connected(p,q)){
                uf.union(p,q);
            }else{
                return edges[i];
            }
        }

        return new int[]{};
    }


    class UF{

        int[] parents;
        int count = 0;
        UF(int n){
            parents = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }

        }

        public int count(){
            return count;
        }

        public void union(int p, int q){

            int fp = find(p);
            int fq = find(q);

            if (fp != fq) {
                parents[fq] = fp;
                count--;
            }
        }

        public boolean connected(int p, int q){
            int fp = find(p);
            int fq = find(q);

            return fq == fp;
        }

        private int find(int x){
            while (x != parents[x]){
                parents[x] = parents[parents[x]];

                x = parents[x];
            }
            return x;
        }

    }
}
