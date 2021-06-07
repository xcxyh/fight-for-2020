package com.xiong.LeetCode.HashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/2 13:26
 * @description： 554. 砖墙 正难则反   记录空隙
 * @modified By：
 * @version: $
 */
public class Leet554_leastBricks {

    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        // 正难则反
        // 记录空隙出现的次数， 空隙最多的地方 穿过的砖最少
        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val > count) {
                count = val;
            }
        }

        return n - count;
    }
}
