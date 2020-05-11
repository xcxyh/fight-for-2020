package com.xiong.LeetCode.DynamicProgramming;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/6 14:42
 * @description：  983. 最低票价  dp() + memo 的形式
 * @modified By：
 * @version: $
 */
public class Leet983_mincostTicket {

    private int[] days;
    private int[] costs;
    private Integer[] memo; // 不能是 int[]
    int[] durations = new int[]{1, 7, 30};
    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days.length];
        //dp(i) 表示 从 第 days[i] 天开始 到旅行的最后一天 的 最低花费
        return dp(0);
    }

    private int dp(int i){
        if (i >= days.length){
            return 0;
        }
        if (memo[i] != null){
            return memo[i];
        }

        int j = i;
        memo[i] = Integer.MAX_VALUE;
        for(int k = 0; k < 3; k++){
            //在 第 days[i] 天 买了 7 天的票  那么 直接 days[i] + 7
            // 找到 days[j] > days[i] + 7 的 下标 j 继续递归
            while (j < days.length && days[j] < days[i] + durations[k]){
                j++;
            }
            memo[i] = Math.min(memo[i], dp(j) + costs[k]);
        }
        return memo[i];
    }

}
