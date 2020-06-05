package com.xiong.LeetCode.JianZhiOffer;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/5 17:00
 * @description：
 * @modified By：
 * @version: $
 */
public class J45_minNumber {

    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0){
            return "";
        }

        int n = nums.length;

        // 先把 int 数组 转成  String 数组
        String[] strs = new String[n];
        for(int i = 0; i < n ; i++){
            strs[i] = String.valueOf(nums[i]);
        }

        //按照 规则  a + b compareTo  b + a 进行排序
        Arrays.sort(strs, (a, b) -> (a + b).compareTo( b + a));

        //拼接结果集返回

        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s);
        }

        return sb.toString();
    }
}
