package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/4 12:28
 * @description：  面试题53 - II. 0～n-1中缺失的数字
 *  1 异或运算
 *  2 由于它是排好序的 还可以用二分
 *  3 差值  下标减去所有的数 剩下的那个数就 是答案
 * @modified By：
 * @version: $
 */
public class Leet_Jz53_missingNumber {

    public int missingNumber(int[] nums) {
        //ans 异或 下标和它本身 剩下的那个数就是 缺失的数

        int ans = nums.length;
        for(int i = 0; i < nums.length; i++){
            ans = ans ^ i ^ nums[i];
        }

        return ans;
    }

    public int missingNumber_2(int[] nums) {
        //ans 下标减去所有的数 剩下的那个数就 是答案

        int ans = nums.length;
        for(int i = 0; i < nums.length; i++){
            ans = ans + (i - nums[i]);
        }

        return ans;
    }


}
