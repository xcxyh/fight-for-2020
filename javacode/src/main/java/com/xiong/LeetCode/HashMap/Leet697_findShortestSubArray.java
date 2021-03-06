package com.xiong.LeetCode.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/20 9:33
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet697_findShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int[] arr = map.getOrDefault(nums[i], new int[3]);

            if (arr[0] == 0) {
                arr[1] = i;
            }

            arr[0] += 1;
            arr[2] = i;

            map.put(nums[i], arr);
        }
        int max = 0;
        int minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {

            int[] arr = entry.getValue();

            if (arr[0] > max) {
                max = arr[0];
                minLen = arr[2] - arr[1] + 1;
            }else if (arr[0] == max) {
                minLen = Math.min(minLen, arr[2] - arr[1] + 1);
            }
        }

        return minLen;
    }

}
