package com.xiong.LeetCode.BinarySearch.旋转数组二分;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/24 16:26
 * @description： 寻找旋转排序数组中的最小值
 * @modified By：
 * @version: $
 */
public class Leet153_findMin {
    public int findMin(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = n - 1;

        while (l < r) {

            int m = l + (r - l) / 2;

            if (nums[m] > nums[r]) {
                l = m + 1;
            }else {
                r = m;
            }

        }
        return nums[l];
    }
}
