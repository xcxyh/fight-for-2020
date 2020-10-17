package com.xiong.LeetCode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/10/6 10:39
 * @description： 834. 树中距离之和
 * @modified By：
 * @version: $
 */
public class Leet834_sumOfDistancesInTree {


    List<List<Integer>> graph;
    int[] depth;
    int[] count;
    int[] ans;
    int N;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        ans = new int[N];
        depth = new int[N];
        count = new int[N];
        this.N = N;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfsFordepthAndCount(0, -1);

        int sum = 0;

        for (int x : depth) {
            sum += x;
        }
        ans[0] = sum;

        dfsForAnswer(0, -1);

        return ans;
    }

    private void dfsFordepthAndCount(int baba, int father) {
        count[baba] = 1;

        for (int erza : graph.get(baba)) {
            if (erza != father) {
                depth[erza] = depth[baba] + 1;
                dfsFordepthAndCount(erza, baba);
                count[baba] += count[erza];
            }
        }
    }

    private void dfsForAnswer(int baba, int father) {
        for (int erza : graph.get(baba)) {
            if (erza != father) {
                ans[erza] = ans[baba] + N - 2 * count[erza];
                dfsForAnswer(erza, baba);
            }
        }
    }
}
