package com.xiong.LeetCode.GreedyAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/29 10:44
 * @description： 330. 按要求补齐数组
 * @modified By：
 * @version: $
 */
public class Leet330_minPatches {


    public int minPatches(int[] nums, int n) {

        int count = 0;

        int len = nums.length;
        int i = 0;
        long x = 1;
        while (x <= n) {
            //区间 [1, x) U [nums[i], nums[i] + x] 是否全部包含 [1, nums[i] + x]
            // 即判断 x 是否 >= nums[i]
            if (i < len && nums[i] <= x) {
                x += nums[i];
                i++;
            }else{
                x <<= 1;
                count++;
            }

        }

        return count;

    }
}
