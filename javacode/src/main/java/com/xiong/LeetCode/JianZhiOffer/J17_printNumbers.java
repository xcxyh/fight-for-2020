package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/3 10:46
 * @description：  剑指 Offer 17. 打印从1到最大的n位数
 * @modified By：
 * @version: $
 */
public class J17_printNumbers {

    public int[] printNumbers(int n) {
        int max = 0;
        while(n-- > 0){
            max = max * 10 + 9;
        }

        int[] ans = new int[max];

        for(int i = 0; i < max; i++){
            ans[i] = i + 1;
        }

        return ans;
    }

}
