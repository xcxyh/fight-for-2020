package com.xiong.LeetCode.ArrayProblems;


import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/15 10:45
 * @description： 560. 和为K的子数组
 * @modified By：
 * @version: $
 */
public class Leet560_subArraySum {


    public static void main(String[] args) {
        System.out.println(new Leet560_subArraySum().subarraySum(new int[]{1, 1, 1}, 2));
    }

    //利用哈希表优化的 前缀和
    private int subarraySum_2(int[] nums, int k) {
        int len = nums.length;
        // 前缀和 --- 前缀和 出现次数
        Map<Integer, Integer> preMap = new HashMap<> ();
        //base
        preMap.put(0,1);// 0 出现 1 次
        int sum0_i = 0;
        int ans = 0;
        for(int i = 0; i < len ; i++){
            sum0_i = sum0_i + nums[i];

            int sum0_j = sum0_i - k; // sum0_i - sum0_j = k
            if (preMap.containsKey(sum0_j)){
                ans += preMap.get(sum0_j);
            }
            // 记录 前缀和出现次数
            preMap.put(sum0_i, preMap.getOrDefault(sum0_i, 0) + 1);
        }
        return ans;
    }


    // 利用前缀和数组
    public int subarraySum(int[] nums, int k) {
        //前缀和数组
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for(int i = 1; i <= len; i++){
            dp[i] = dp[i-1] + nums[i-1];
        }

        int ans = 0;
        for(int i = 1; i <= len ; i++){
            for(int j = 0; j < i; j++){
                int temp = dp[i] - dp[j];
                if (temp == k){
                    ans++;
                }
            }
        }
        return ans;
    }
}
