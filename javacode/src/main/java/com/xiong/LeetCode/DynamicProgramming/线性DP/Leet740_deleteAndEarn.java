package com.xiong.LeetCode.DynamicProgramming.线性DP;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/5 10:51
 * @description：  740. 删除并获得点数   相同值求和 ，转化为 打家劫舍问题
 * @modified By：
 * @version: $
 */
public class Leet740_deleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] s = new int[max + 5];

        for (int num : nums) {
            s[num] += num;
        }
        int first = s[0];
        int two = Math.max(s[0], s[1]);
        int ans = 0;
        for (int i = 2; i < s.length; i++) {

            ans = Math.max(first + s[i], two);
            first = two;
            two = ans;
        }

        return ans;
    }

}
