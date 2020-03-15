package com.xiong.LeetCode.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/14 17:17
 * @description：
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别正好是1。
 * <p>
 * 现在，给定一个整数数组，你需要在所有可能的子序列中找到最长的和谐子序列的长度。不要求连续
 * @modified By：
 * @version: $
 */
public class H3_findLHS {
    //返回的是长度  序列的元素不一定是数组的连续元素
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        //将所有元素的值做键 出现的次数做值
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        //遍历 map中的所有键
        for (int key : map.keySet()) {
            // 依次 求 num 和 num+1 元素的和 取最大的
            if (map.containsKey(key + 1)){
                longest = Math.max(longest, map.get(key) + map.get(key + 1));
            }

        }
       return longest;
    }

}
