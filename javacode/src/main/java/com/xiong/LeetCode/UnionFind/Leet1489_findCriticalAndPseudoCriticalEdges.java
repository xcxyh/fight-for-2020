package com.xiong.LeetCode.UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/21 12:52
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1489_findCriticalAndPseudoCriticalEdges {

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        int size = edges.length;

        int[][] newedges = new int[size][4];

        for (int i = 0; i < size; i++) {
            newedges[i][0] = edges[i][0];
            newedges[i][1] = edges[i][1];
            newedges[i][2] = edges[i][2];
            newedges[i][3] = i;
        }

        int minVal = 0;

        Arrays.sort(newedges, (a, b) -> (a[2] - b[2]));

        UF ufstd = new UF(n);
        for (int[] edge : newedges) {
            if (ufstd.union(edge[0], edge[1])){
                minVal += edge[2];
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        // 遍历所有的边 先判断是否是关键边，然后再判断是否是伪关键边
        for (int i = 0; i < size; i++) {

            // 1
            UF uf = new UF(n);
            int newV = 0;
            // 删去该边
            for (int j = 0; j < size; j++) {
                int[] edge = newedges[j];
                if (j != i && uf.union(edge[0], edge[1])){
                    newV += edge[2];
                }
            }
            // 如果不能组成最小生成树 或者  权值和增加
            if (uf.count() != 1 || (uf.count() == 1 && newV > minVal)){
                ans.get(0).add(newedges[i][3]);
                // 不用再判断是否是伪关键边了， 因为 关键边也满足 伪关键边 的 性质
                System.out.println(newedges[i][3]);
                continue;
            }
            //2
            uf = new UF(n);
            newV = 0;
            // 先连接该边
            uf.union(newedges[i][0], newedges[i][1]);
            newV += newedges[i][2];
            for (int j = 0; j < size; j++) {
                int[] edge = newedges[j];
                if (uf.union(edge[0], edge[1])){
                    newV += edge[2];
                }
            }

            if (newV == minVal){
                ans.get(1).add(newedges[i][3]);
            }

        }
        return ans;

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

        boolean union(int p , int q) {
            int fp = find(p);
            int fq = find(q);

            if (fp != fq){
                f[fp] = fq;
                count--;
                return true;
            }
            return false;
        }

        int find(int x) {
            while (x != f[x]) {
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
