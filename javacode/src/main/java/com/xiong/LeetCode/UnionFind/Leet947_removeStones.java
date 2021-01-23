package com.xiong.LeetCode.UnionFind;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/15 16:19
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet947_removeStones {


    public int removeStones(int[][] stones) {
        int n = stones.length;

        int[] f = new int[n];

        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        int ans = 0;
        // 按点合并 效率较低
        for ( int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int fi = find(f, i);
                int fj = find(f, j);
                if (fi != fj){
                    if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                        f[fi] = fj;
                        ans++;
                    }
                }

            }
        }
        return ans;
    }

    private int find(int[] f, int x) {
        while (f[x] !=x ) {
            f[x] = f[f[x]];
            x = f[x];
        }
        return f[x];
    }

    // 按边合并   将 x + 10000 与 y 相连 为一条边
    int[] p = new int[20005];
    int find(int x){
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
    void union(int x, int y){
        p[find(x)] = find(y);
    }
    public int removeStones2(int[][] stones) {
        int n = stones.length;
        for(int i = 0; i < 20005; i++) p[i] = i;
        for(int[] stone: stones){
            int x = stone[0], y = stone[1];
            union(x, y+10000);
        }
        Set<Integer> set = new HashSet<>();
        for(int[] stone: stones){
            int x = stone[0];
            set.add(find(x));
        }
        return n-set.size();
    }
}
