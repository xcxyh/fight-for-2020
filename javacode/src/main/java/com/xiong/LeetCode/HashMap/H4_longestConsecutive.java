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

    //第二次  忘记做法了
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        for(int n : nums){
            set.add(n);
        }
        int ans = 0;
        for(int n : nums){
            int temp = 0;
            if (set.contains(n)){
                set.remove(n);

                int cur = n;
                temp = 1; // 该数本身 长度为 1
                while(set.contains(cur - 1)){
                    set.remove(--cur);
                }
                //更新temp  左边的 个数
                temp += (n - cur);
                cur = n;
                while(set.contains(cur + 1)){
                    set.remove(++cur);
                }
                // 右边的 个数
                temp += (cur - n);
            }

            ans = Math.max(ans, temp);
        }
        return ans;
    }


    /**
     * 输入: [100, 4, 200, 1, 3, 2]
     * 输出: 4
     * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */
    public int longestConsecutive_1(int[] nums) {
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
