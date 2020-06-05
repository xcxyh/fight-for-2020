package com.xiong.LeetCode.JianZhiOffer;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/3 16:11
 * @description： 面试题66. 构建乘积数组   解法： 先 正着遍历 再反着遍历  leet238
 * @modified By：
 * @version: $
 */
public class J66_constructArr {
    //ac
    public int[] constructArr(int[] a) {

        if (a == null || a.length == 0) {
            return a;
        }
        int n = a.length;
        int[] left = new int[n];
        int[] right = new int[n]; // 这里 没有必要再创建一个数组  用一个 临时数 temp 代替即可
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        //双重for 循环 超时
        // 先 正着遍历 再反着遍历
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * a[i - 1];
            // System.out.println(left[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
            left[i] = left[i] * right[i];
        }

        return left;
    }
}
