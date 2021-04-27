package com.xiong.LeetCode.ArrayProblems;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/12 9:54
 * @description： 179. 最大数  跟 J45_minNumber 一致
 * @modified By：
 * @version: $
 */
public class Leet179_largestNumber {

    public String largestNumber(int[] nums) {

        int n = nums.length;

        // 先把 int 数组 转成  String 数组
        String[] strs = new String[n];
        for(int i = 0; i < n ; i++){
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (a, b) -> ((b + a).compareTo(a + b)));

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str);
            System.out.println(str);
        }

        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
}
