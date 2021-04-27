package com.xiong.LeetCode.TwoIndex;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/7 11:01
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet26_removeDuplicates {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return n;
        }

        int i = 1, j = 1;

        while (j < n) {
            if (nums[i - 1] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}
