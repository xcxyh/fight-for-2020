package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/7 9:55
 * @description： 1486. 数组异或操作
 * @modified By：
 * @version: $
 */
public class Leet1486_xorOperation {

    public int xorOperation(int n, int start) {
        int ans = 0;
        for (int i = 0;  i < n; i++) {
            int cur = start + 2 * i;
            ans = ans ^ cur;
        }
        return ans;
    }

    // 位运算做法
    public int xorOperation_bit(int n, int start) {


        int b0 = n & start & 1;

        int s = start / 2;

        int res = xorcalcu(s - 1) ^ xorcalcu(s + (n - 1));

        return (res << 1) + b0;
    }

    private int xorcalcu(int n) {
        int ans = 0;


        switch (n % 4) {
            case 0:
                ans = n;
                break;
            case 1:
                ans = 1;
                break;
            case 2:
                ans = n + 1;
                break;
            case 3:
                ans = 0;
                break;
        }

        return ans;
    }
}
