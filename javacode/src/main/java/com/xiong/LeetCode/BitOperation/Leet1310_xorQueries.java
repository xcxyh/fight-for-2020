package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/12 10:50
 * @description： 1310. 子数组异或查询
 * @modified By：
 * @version: $
 */
public class Leet1310_xorQueries {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        int[] pre = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }

        int qlen = queries.length;

        int[] ans = new int[qlen];

        for (int i = 0; i < qlen; i++) {

            int[] range = queries[i];

            ans[i] = pre[range[0]] ^ pre[range[1] + 1];


        }
        return ans;
    }
}
