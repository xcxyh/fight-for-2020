package com.xiong.LeetCode.GreedyAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/6 15:32
 * @description： 621. 任务调度器
 * @modified By：
 * @version: $
 */
public class Leet621_leastInterval {

    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];

        int maxVal = 0;
        // 统计每个字符出现个数，并记录最大出现次数
        for (char c : tasks) {
            int x = c - 'A';
            arr[x]++;
            if (arr[x] > maxVal) {
                maxVal = arr[x];
            }
        }
        // 统计出现最多次数的 字符有几个
        int maxNum = 0;
        for (int x : arr) {
            if (x == maxVal) {
                maxNum++;
            }
        }
        //贪心， 最多分成 maxVal组 ，前 maxVal - 1 组 一共 n + 1 个位置， 最后一组 有 maxNum 个位置
        // 代表 如果有 待命  的最大长度
        int shouldbe = (n + 1) * (maxVal - 1) + maxNum;
        return Math.max(shouldbe, tasks.length);
    }
}
