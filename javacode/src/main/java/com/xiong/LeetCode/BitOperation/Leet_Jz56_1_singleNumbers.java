package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/28 8:19
 * @description： 面试题56 - I. 数组中数字出现的次数  相似的题有  136  137 645
 * @modified By：
 * @version: $
 */
public class Leet_Jz56_1_singleNumbers {

    public int[] singleNumbers(int[] nums) {
        // 位运算 异或
        int ans = 0;
        for(int n : nums){
            ans = ans ^ n;
        }
        int[] ret = new int[2];
        // 从 ans 中分出两个不相同的数来
        //n & (-n) 得到 n 的位级表示中最低的那一位 1
        int diff = ans & -ans; // 得到 ans 中最低的一位 1
        // ans 为 ret[0] 和 ret[1] 异或的结果
        // 那么，diff 为 ans 中为1的位 ，即  ret[0] 和 ret[1] 在 diff 位 必不相同
        // 则 ret[0] & diff  的结果 一定 不同于 ret[1] & diff
        // 根据这个 为 1 的位 对 数组进行分组
        // 相同的数字必然在一个组里
        // 不同的数字必然在不同的组里
        for(int n : nums){
            if ((diff & n) == 0){
                ret[0] = ret[0] ^ n;
            }else{
                ret[1] = ret[1] ^ n;
            }

        }
        return ret;
    }
}
