package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/11 10:25
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1734_decode {

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int x = 0;
        for (int i = 1; i <= n; i++) {
            x = x ^ i;
        }
        // perm 数组 是一个 从 1 到 n 的所有正整数的 一个排列
        int zum = 0;
        // perm[0] = x XOR encoded[1] XOR encoded[3] XOR encoded[5] ...
        for (int i = 1; i < n - 1; i = i + 2) {
            zum = zum ^ encoded[i];
        }

        int[] perm = new int[n];
        perm[0] = zum ^ x;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }

        return perm;
    }
}
