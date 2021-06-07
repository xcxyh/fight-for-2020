package com.xiong.LeetCode.ArrayProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/15 11:19
 * @description： 523. 连续的子数组和
 * @modified By：
 * @version: $
 */
public class Leet523_checkSubarraySum {


    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (!map.containsKey(sum % k)) {
                map.put(sum % k, i);
            }else {
                int preIndex = map.get(sum % k);
                if (i - preIndex > 1) {
                    return true;
                }
            }

        }
        return false;

    }

    public boolean checkSubarraySum1(int[] nums, int k) {

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
