package com.xiong.LeetCode.ArrayProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/6/3 9:54
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet525_findMaxLength {

    public int findMaxLength(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);
        int count = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            }else {
                count--;
            }
            if (map.containsKey(count)) {
                int preIndex = map.get(count);
                ans = Math.max(ans, i - preIndex);

            }else {
                map.put(count, i);

            }
        }

        return ans;
    }
}
