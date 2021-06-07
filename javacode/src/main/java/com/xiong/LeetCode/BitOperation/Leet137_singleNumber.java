package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/30 13:57
 * @description： 137. 只出现一次的数字 II  统计每一位 中 1 出现的次数， % 3 后不为 0 则证明 ans 中对应这一位为 1
 * @modified By：
 * @version: $
 */
public class Leet137_singleNumber {

    public int singleNumber(int[] nums) {
        // 统计每一位 中 1 出现的次数， % 3 后不为 0 则证明 ans 中对应这一位为 1

        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            int bit = 1 << i;
            for (int num : nums) {
                if ( (num & bit) != 0) {
                    count++;
                }
            }
            if (count % 3 == 1) {
                ans = ans | bit;
            }
        }
        return ans;
    }
}
