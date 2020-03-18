package com.xiong.LeetCode.HashMap;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/14 17:35
 * @description： LeetCode HARD
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * <p>
 * 要求算法的时间复杂度为 O(n)。
 * <p>
 * 一般在leetcode中，对时间复杂度有要求，就用空间来换，对空间复杂度有要求，就用时间来换。
 * <p>
 * 所以不能对数组排序
 * @modified By：
 * @version: $
 */
public class H4_longestConsecutive {

    /**
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */
    public int longestConsecutive(int[] nums) {
        //添加到 set 中
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        int longest = 0;
        //遍历到一个时  查看它相邻的数字是否在 set 中
        for (int num : nums) {
            if (numsSet.remove(num)) {  // 将与当前元素相邻的连续序列全都从集合里删除了
                // 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
                int currentLongest = 1;
                int current = num;
                while (numsSet.remove(current - 1)) current--;
                currentLongest += (num - current);
                // 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
                current = num;
                while(numsSet.remove(current + 1)) current++;
                currentLongest += (current - num);
                // 搜索完后更新longest.
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }

}
