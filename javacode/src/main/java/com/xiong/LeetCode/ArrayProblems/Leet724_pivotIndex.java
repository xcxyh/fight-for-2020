package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/28 9:47
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet724_pivotIndex {


    public int pivotIndex(int[] nums) {

        int n = nums.length;
        int sum = 0;
        int prefix = 0;
        for (int num : nums) {
            sum += num;
        }

        for (int i = 0; i < n; i++) {

            if (prefix * 2 + nums[i] == sum) {
                return i;
            }
            prefix += nums[i];
        }

        return -1;
    }
}
