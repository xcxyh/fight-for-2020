package com.xiong.LeetCode.DailyProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/4 10:52
 * @description： 42. 接雨水  困难
 * @modified By：
 * @version: $
 */
public class D42_trap {

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 1, 0, 1, 2, 0, 1, 0}));

    }

    /**
     * @author: xiongcong
     * @Date: 2020/4/4 10:56
     * @Description: 动态规划 （这方法基本万能）
     */
    public int trap_dp(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        //dp_left[i] 表示 i 位置 左边 最高的墙的高度 不包括 height[i] 本身
        //dp_right[i] 表示 i 位置 右边 最高的墙的高度 不包括 height[i] 本身
        //dp_left[i] = Max(dp_left[i-1], height[i-1])
        //dp_right[i] = Max(dp_right[i+1], height[i+1])
        int[] dp_left = new int[len];
        int[] dp_right = new int[len];

        for (int i = 1; i < len; i++) {
            dp_left[i] = Math.max(dp_left[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {  //要倒着遍历  因为 要先算 dp_right[i+1] 再算  dp_right[i]
            dp_right[i] = Math.max(dp_right[i + 1], height[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i <len ; i++) {
            int min = Math.min(dp_left[i],dp_right[i]); // 木桶效应 小的决定容量
            if (min > height[i]) { // 保证能装
                ans += (min - height[i]);
            }
        }
        return ans;
    }


    // 困难  ac

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int max_index = 0;
        int max = 0;
        //找出最高点
        for (int i = 0; i < len; i++) {
            if (height[i] > max) {
                max = height[i];
                max_index = i;
            }
        }
        // 从两端向最高点 遍历
        int high = height[0]; //次高
        int ans = 0;
        for (int i = 1; i < max_index; i++) {
            if (height[i] > high) {
                high = height[i];
            }
            if (high > height[i]) {
                ans += high - height[i];
            }
        }
        high = height[len - 1]; //次高
        for (int i = len - 1; i > max_index; i--) {
            if (height[i] > high) {
                high = height[i];
            }
            if (height[i - 1] < high) {
                ans += high - height[i - 1];
            }
        }
        return ans;
    }

}
