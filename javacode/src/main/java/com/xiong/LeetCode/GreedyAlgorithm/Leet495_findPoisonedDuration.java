package com.xiong.LeetCode.GreedyAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/12 13:04
 * @description： 495. 提莫攻击
 * @modified By：
 * @version: $
 */
public class Leet495_findPoisonedDuration {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0){
            return 0;
        }

        int ans = duration;
        for (int i = 1; i < timeSeries.length; i++){
            ans += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return ans;
    }
}
