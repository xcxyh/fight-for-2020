package com.xiong.LeetCode.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/11/27 12:11
 * @description： 454. 四数相加 II
 * @modified By：
 * @version: $
 */
public class Leet454_fourSumCount {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int ans = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = -(c + d);
                if (map.containsKey(sum)) {
                    ans += map.get(sum);
                }
            }
        }
        return ans;
    }


}
