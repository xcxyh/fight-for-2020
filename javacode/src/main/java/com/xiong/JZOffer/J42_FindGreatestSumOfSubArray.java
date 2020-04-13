package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/10 18:21
 * @description： 连续子数组的最大和
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和
 * @modified By：
 * @version: $
 */
public class J42_FindGreatestSumOfSubArray {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int len = array.length;
        //dp
        //dp[i] 表示 包含第 i 个元素时 的0 - i最大连续子序和
        // dp[i-1]>0 则  dp[i] = dp[i -1] + array[i];
        // else dp[i] = array[i];
        int[] dp = new int[len];
        dp[0] = array[0];
        int ans =  array[0];
        for(int i = 1; i< len ; i++){
            if (dp[i-1]>0){
                dp[i] = dp[i -1] + array[i];
            }else{
                dp[i] = array[i];
            }
            ans  = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
