package com.xiong.LeetCode.ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/10/5 10:29
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet18_fourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;
        for (int a = 0; a < n; a++) {

            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            for (int b = a + 1; b < n; b++) {

                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                int sum = target - nums[a] - nums[b];

                int d = n - 1;
                for (int c = b + 1; c < n; c++) {

                    if (c > b + 1 && nums[c] == nums[c - 1]) {
                        continue;
                    }

                    while (d > c && nums[c] + nums[d] > sum) {
                        d--;
                    }

                    if (c == d) {
                        break;
                    }
                    if (nums[c] + nums[d] == sum) {
                        ans.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                    }

                }
            }
        }

        return ans;
    }

}
