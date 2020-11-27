package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/10/26 10:08
 * @description：   1365. 有多少小于当前数字的数字
 * @modified By：
 * @version: $
 */
public class Leet1365_smallerNumbersThanCurrent {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] bucket = new int[101];

        for (int i = 0; i<nums.length; i ++){
            bucket[nums[i]]++;
        }
        int count = 0;
        for (int i = 0; i<bucket.length; i ++){
            int temp = bucket[i];
            bucket[i] = count;
            count += temp;
        }

        for (int i = 0; i<nums.length; i ++){
            nums[i] = bucket[nums[i]];
        }
        return nums;
    }
}
