package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/2 8:16
 * @description： 面试题64. 求1+2+…+n
 * @modified By：
 * @version: $
 */
public class J64_sumNums {


    //求 1+2+...+n ，
    // 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    private int ans = 0;
    public int sumNums(int n) {
        boolean bool = n > 0 && sumNums(n-1) > 0;
        ans += n;
        return ans;
    }
}
