package com.xiong.LeetCode.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/4 9:54
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet781_numRabbits {

    // 计数  +  分组统计个数
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            key = key + 1;
            if (val > key) {
                int count = val % key == 0 ? val / key : val / key + 1;
                ans += count * key;
            } else {
                ans += key;
            }

        }

        return ans;
    }
}
