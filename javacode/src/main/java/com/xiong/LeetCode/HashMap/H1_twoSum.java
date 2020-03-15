package com.xiong.LeetCode.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/14 17:07
 * @description： 两数之和 复杂度  O(n) 和 O(n)
 * @modified By：
 * @version: $
 */
public class H1_twoSum {


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(target - nums[i])) {
                return new int[]{indexMap.get(target - nums[i]), i};
            } else {
                indexMap.put(nums[i], i);
            }
        }
        return null;

    }
}
