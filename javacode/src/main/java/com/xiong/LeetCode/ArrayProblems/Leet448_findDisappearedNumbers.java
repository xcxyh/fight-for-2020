package com.xiong.LeetCode.ArrayProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/13 9:47
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet448_findDisappearedNumbers {


    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            while (nums[i] - 1 != i) {
                if (nums[i] == nums[nums[i] - 1]) {
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                ans.add(i + 1);
            }
        }
        return ans;
    }


    private void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
