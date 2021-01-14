package com.xiong.LeetCode.UnionFind;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/11 9:24
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1202_smallestStringWithSwaps {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs == null || pairs.size() == 0) {
            return s;
        }

        int n = s.length();

        if (n <= 1) {
            return s;
        }

        int[] f = new int[n];

        for (int i = 0; i < n; i++) {
            f[i] = i;
        }

        for (int i = 0; i < pairs.size(); i++) {
            List<Integer> pair = pairs.get(i);
            int p = pair.get(0);
            int q = pair.get(1);
            merge(f, p, q);

        }


        Set<Integer> groupf = new HashSet<>();
        for (int i = 0; i < n; i++) {
            groupf.add(f[i]);
        }

        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();

        for (int i : groupf) {
            map.put(i, new PriorityQueue<>());
        }

        for (int i = 0; i < n; i++) {
            int root = find(f, i);
            map.get(root).offer(s.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = find(f, i);
            sb.append(map.get(root).poll());
        }

        return sb.toString();

    }

    void merge(int[] f, int p, int q) {
        int fp = find(f, p);
        int fq = find(f, q);

        if (fp != fq) {
            f[fp] = fq;
        }
    }

    int find(int[] f, int x) {

        while(f[x] != x) {
            f[x] = f[f[x]];
            x = f[x];
        }

        return f[x];

    }

}
