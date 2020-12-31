package com.xiong.LeetCode.GreedyAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/12 12:38
 * @description： 376. 摆动序列    贪心的选择 峰和谷
 * @modified By：
 * @version: $
 */
public class Leet376_wiggleMaxLength {


    public int wiggleMaxLength(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }
        // 贪心的选择 峰和谷
        int n = nums.length;

        if (n < 2){
            return n;
        }
        int ans = 1;
        int diff = 0;
        for ( int i = 1; i < n; i++){
            int minus = nums[i] - nums[i - 1];
            if (minus != 0){
                if (minus * diff <= 0) {
                    ans++;
                }
                diff = minus;
            }

        }
        return ans;
    }

}
