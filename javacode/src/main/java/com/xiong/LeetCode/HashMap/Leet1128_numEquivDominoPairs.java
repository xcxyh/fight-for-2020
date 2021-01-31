package com.xiong.LeetCode.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/26 8:58
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1128_numEquivDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        int count = 0;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] domin = dominoes[i];
            int a = domin[0];
            int b = domin[1];
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }
            String key = a + "_" + b;

            map.put(key, map.getOrDefault(key, 0) + 1);

        }

        for (int f : map.values()) {
            count += f * (f- 1) / 2;
        }

        return count;

    }

}
