package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/22 20:58
 * @description： 375. 猜数字大小 II
 * @modified By：
 * @version: $
 */
public class Leet375_getMoneyAmount {

    private Integer[][] memo;
    public int getMoneyAmount(int n) {
        memo = new Integer[n + 1][n + 1];
        return calculate(1, n);
    }

    public int calculate(int low, int high) {
        if (low >= high) {
            return 0;
        }

        if (memo[low][high] != null){
            return memo[low][high];
        }
        int min = Integer.MAX_VALUE;
        for(int i = low; i<= high; i++){

            int left = calculate(low, i - 1);
            int right = calculate(i + 1, high);
            int temp = i + Math.max(left, right);

            min = Math.min(min, temp);
        }
        memo[low][high] = min;

        return min;

    }
}
