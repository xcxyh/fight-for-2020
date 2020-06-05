package com.xiong.LeetCode.ArrayProblems;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/4 9:23
 * @description： 238. 除自身以外数组的乘积
 * 与 面试题66. 构建乘积数组 J66_constructArr  相同
 * @modified By：
 * @version: $
 */
public class Leet238_productExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;

        int[] ans = new int[n];
        //init
        Arrays.fill(ans, 1);

        int temp = 1;

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            temp = temp * nums[i + 1];
            ans[i] = ans[i] * temp;
        }

        return ans;
    }
}
