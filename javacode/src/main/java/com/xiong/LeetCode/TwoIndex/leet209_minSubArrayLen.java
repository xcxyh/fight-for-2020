package com.xiong.LeetCode.TwoIndex;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/28 16:47
 * @description： 209. 长度最小的子数组  双指针的 滑动窗口
 * @modified By：
 * @version: $
 */
public class leet209_minSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        //滑动窗口
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;

        int ans = n + 1; // 此时 n+1  就相当于 无穷大
        while(right < n){
            if (sum < s){
                sum += nums[right];
                right++;
            }
            // 左指针移动
            while(sum >= s){
                // 更新答案
                ans = Math.min(ans, right - left);
                sum -= nums[left];
                left++;
            }

        }
        return ans == n + 1 ? 0 : ans;

    }
}
