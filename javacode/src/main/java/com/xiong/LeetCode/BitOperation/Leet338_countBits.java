package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/3/3 10:07
 * @description： 338. 比特位计数  位运算 + dp
 * @modified By：
 * @version: $
 */
public class Leet338_countBits {

    // 方法3 ：位运算 + dp
    public int[] countBits_NBPLUS(int num) {
        int[] ans = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }


    // 方法2 ：位运算 + dp
    public int[] countBits_NB(int num) {
        int[] ans = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

    // 方法1 ： 位运算
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];

        for (int i = 0;i <= num; i++) {
            ans[i] = getBit(i);
        }
        return ans;
    }

    private int getBit(int n) {
        int cnt = 0;
        while (n > 0) {

            n = n & (n - 1);
            cnt++;
        }
        return cnt;
    }
}
