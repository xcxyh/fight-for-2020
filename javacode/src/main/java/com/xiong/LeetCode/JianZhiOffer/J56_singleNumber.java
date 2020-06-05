package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/30 14:45
 * @description： 面试题56 - II. 数组中数字出现的次数 II    leetCode 137 题
 * @modified By：
 * @version: $
 */
public class J56_singleNumber {

    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        // 记录二进制位 每一位 出现的次数  对 3 取余之后 组合起来 就是 答案
        for(int n : nums){
            for(int j = 0; j < 32; j++){
                count[j] += n & 1;
                n = n >> 1;
            }

        }
        // 对 3 取 模
        for(int i = 0; i < 32; i ++){
            count[i] = count[i] % 3;
        }

        int ans = 0;
        // 二进制数组转 数字
        for(int i = 0; i < 32; i ++){
            ans += count[i] * (1 << i) ;
        }
        return ans;
    }
}
