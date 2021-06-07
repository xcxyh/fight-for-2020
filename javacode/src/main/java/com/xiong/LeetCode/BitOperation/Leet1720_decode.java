package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/6 10:06
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1720_decode {

    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;

        int[] ans = new int[n + 1];
        ans[0] = first;
        for (int i = 0; i < n; i++) {
            ans[i + 1] = encoded[i] ^ ans[i];
        }
        return ans;

    }
}
