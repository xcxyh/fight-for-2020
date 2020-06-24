package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/15 22:03
 * @description： 260. 只出现一次的数字 III
 * @modified By：
 * @version: $
 */
public class Leet260_singleNumber {

    public int[] singleNumber(int[] nums) {
        // 位运算

        int merge = 0;

        for(int x : nums){
            merge ^= x;
        }
        // merge = n1 ^ n2 则找出 merge 中的 一位 1 来将 n1 和 n2 分开
        // 注意  - 的优先级 比 & 高  后面要加括号
        int diff = merge - ((merge - 1) & merge);
        //System.out.println(merge);
        int[] ans = new int[2];

        for(int x : nums){
            if ( (x & diff) == 0){
                ans[0] ^= x;
            }else{
                ans[1] ^= x;
            }
        }
        return ans;
    }
}
