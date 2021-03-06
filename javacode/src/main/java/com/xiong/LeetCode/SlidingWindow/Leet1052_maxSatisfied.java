package com.xiong.LeetCode.SlidingWindow;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/23 9:28
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1052_maxSatisfied {


    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int n = customers.length;

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                cnt += customers[i];
            }
        }
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 1) {
                cnt += customers[i];
            }
        }
        int ans = cnt;
        for (int i = X; i < n; i++) {

            if (grumpy[i] == 1) {
                cnt += customers[i];
            }

            if (grumpy[i - X] == 1) {
                cnt -= customers[i - X];
            }

            ans = Math.max(ans, cnt);

        }

        return ans;
    }
}
