package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/14 15:27
 * @description： 1300. 转变数组后最接近目标值的数组和  从target / len 开始，答案具有单调性
 * @modified By：
 * @version: $
 */
public class Leet1300_findBestValue {


    public int findBestValue(int[] arr, int target) {
        int n = arr.length;
        int avg = target / n;
        //find max
        int max = 0;
        for (int x : arr) {
            max = Math.max(x, max);
        }
        // if max < avg return max
        if (max < avg) {
            return max;
        }
        int pre = Integer.MAX_VALUE; // 记录上一轮的差值
        // i start from avg 枚举
        int i = avg;
        while (true) {
            int sum = 0;
            for (int x : arr) {
                if (x > i) {
                    sum += i;
                } else {
                    sum += x;
                }
            }
            int cur = Math.abs(sum - target);
            //比较差值，看前一个点是否是最小值
            if (cur >= pre) {
                return i - 1;
            }
            pre = cur;
            i++;
        }

    }


    public int findBestValue_1(int[] arr, int target) {
        int n = arr.length;
        int avg = target / n;
        // 记录前一轮的差值
        int pre = Integer.MAX_VALUE;
        int max = 0;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        // 数组里的最大值比  avg 还要小 直接取 max
        if (max < avg) {
            return max;
        }
        // 从平均值开始遍历
        for (int i = avg; ; ++i) {
            // 记录每轮的总和
            int sum = 0;
            for (int value : arr) {
                if (value > i) {
                    sum += i;
                } else {
                    sum += value;
                }
            }
            // 比较差值，看前一个点是否是最小值
            if (Math.abs(sum - target) >= pre) {
                return i - 1;
            }
            // 更新差值记录
            pre = Math.abs(sum - target);
        }
    }
}
