package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/18 10:30
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1442_countTriplets {

    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n + 1];

        for (int i = 1; i <= n; i++) {

            pre[i] = pre[i - 1] ^ arr[i - 1];
        }


        int ans = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = i + 2; j <= n; j++) {
                if ((pre[i] ^ pre[j]) == 0) {
                    ans += j - i - 1;
                }

            }
        }

        return ans;
    }
}
