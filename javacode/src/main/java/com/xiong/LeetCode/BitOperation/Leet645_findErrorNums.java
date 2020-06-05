package com.xiong.LeetCode.BitOperation;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/30 16:09
 * @description： 645. 错误的集合  与 Leet_Jz56_1_singleNumbers 相似
 * @modified By：
 * @version: $
 */
public class Leet645_findErrorNums {

    public int[] findErrorNums(int[] nums) {
        // 异或 下标 剩下的 数 即为所求的两个 数的 异或
        int merge = 0;
        for (int i = 0; i < nums.length; i++) {
            merge = merge ^ (i + 1) ^ nums[i];
        }
        // 把两个数从 这个异或结果中分离出来
        int diff = merge & -merge; // 这两个数 在 diff 这一位上 不相同
        //System.out.println(merge);
        int[] ans = new int[2];
        // 分开
        for (int i = 0; i < nums.length; i++) {

            if ((diff & (i + 1)) == 0) {
                ans[0] = ans[0] ^ (i + 1);
            } else {
                ans[1] = ans[1] ^ (i + 1);
            }

            if ((diff & nums[i]) == 0) {
                ans[0] = ans[0] ^ nums[i];
            } else {
                ans[1] = ans[1] ^ nums[i];
            }
        }
        // 此时分开了，但是  不知道 哪个 为 重复的 哪个为缺失的
        for (int n : nums) {
            if (ans[1] == n) {
                int temp = ans[0];
                ans[0] = ans[1];
                ans[1] = temp;
                break;
            }
        }

        return ans;
    }
}
