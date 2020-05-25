package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/15 11:19
 * @description： 523. 连续的子数组和
 * @modified By：
 * @version: $
 */
public class Leet523_checkSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {

        //前缀和
        int len = nums.length;
        int[] s = new int[len + 1]; // 注意 大小为 len + 1
        s[0] = 0;

        for(int i = 1; i <= len; i++){ // 注意 i <= len
            s[i] = s[i - 1] + nums[i - 1];
        }

        for(int i = 2; i <= len ; i++){ // 注意 i <= len
            for(int j = 0; j < i; j++){
                if (i - j >= 2){
                    int temp = s[i] - s[j];

                    if (k == 0 && temp == k){
                        return true;
                    }

                    if (k != 0 && temp % k == 0){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
