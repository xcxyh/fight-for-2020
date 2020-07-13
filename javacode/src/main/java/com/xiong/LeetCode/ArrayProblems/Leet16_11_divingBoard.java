package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/8 18:55
 * @description：  面试题 16.11. 跳水板
 * @modified By：
 * @version: $
 */
public class Leet16_11_divingBoard {


    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0){
            return new int[]{};
        }

        if (shorter == longer){
            return new int[]{shorter*k};
        }

        //长度不同
        int[] ans = new int[k + 1];


        for(int i = 0 ; i <= k; i++){
            ans[i] = shorter*(k - i) + longer*i;
        }

        return ans;

    }
}
