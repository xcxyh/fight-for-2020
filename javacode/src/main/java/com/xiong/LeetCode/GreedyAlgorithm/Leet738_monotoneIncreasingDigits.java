package com.xiong.LeetCode.GreedyAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/15 10:49
 * @description： 738. 单调递增的数字
 * @modified By：
 * @version: $
 */
public class Leet738_monotoneIncreasingDigits {

    public int monotoneIncreasingDigits(int N) {

        // 先向后找 第一个递减的位置

        //然后再返回向前找 最近的 一个 递增的位置 ，把当前数减 1，后面都赋值 9
        // 例 ： 12333332
        //         ->  i
        //         i <-
        //       12299999
        char[] chs = String.valueOf(N).toCharArray();

        int n = chs.length;

        int i = n - 1;

        while (i < n - 1 && chs[i] <= chs[i + 1]) {
            i++;
        }

        if (i < n - 1) {
            while (i > 0 && chs[i] <= chs[i - 1]) {
                i--;
            }
            chs[i] = (char) (chs[i] - 1);
            for (int j = i + 1; j < n; j++) {
                chs[j] = '9';
            }
        }

        return Integer.valueOf(new String(chs));
    }

}
