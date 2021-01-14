package com.xiong.LeetCode.ArrayProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/10 9:23
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet228_summaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<String> ans = new ArrayList<>();

        if (nums.length == 1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }

        int n = nums.length;
        int i = 0;
        int j = i;
        while (j < n) {

            if (j == n - 1 || nums[j] + 1 != nums[j + 1]) {
                if (i == j) {
                    ans.add(String.valueOf(nums[j]));
                }else{
                    ans.add(nums[i] + "->" + nums[j]);
                }
                i = j + 1;
            }
            j++;
        }

        return ans;
    }

}
