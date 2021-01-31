package com.xiong.LeetCode.UnionFind;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/31 10:07
 * @description：  839. 相似字符串组  简单冰茶集
 * @modified By：
 * @version: $
 */
public class Leet839_numSimilarGroups {


    public int numSimilarGroups(String[] strs) {

        int n = strs.length;
        UF uf = new UF(n);
        for(int i = 0;i < n;i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    uf.merge(i, j);
                }
            }
        }

        return uf.count();
    }

    private boolean isSimilar(String s1, String s2) {

        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 != c2) {
                count++;
            }
        }

        return count == 0 || count == 2;

    }

    class UF {
        private int[] f;
        private int count;

        UF (int n) {
            f = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }
        }

        private void merge(int p, int q) {
            int fp = find(p);
            int fq = find(q);

            if (fp != fq) {
                f[fp] = fq;
                count--;
            }
        }

        private int find(int x) {
            while(f[x] != x) {
                f[x] = f[f[x]];
                x = f[x];
            }
            return f[x];
        }

        private int count() {
            return count;
        }
    }

}
