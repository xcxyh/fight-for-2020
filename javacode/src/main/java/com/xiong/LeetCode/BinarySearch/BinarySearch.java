package com.xiong.LeetCode.BinarySearch;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/24 14:38
 * @description： 二分查找 每次都能将查找区间减半，这种折半特性的算法时间复杂度为 O(logN)。
 * @modified By：
 * @version: $
 */
public class BinarySearch {

    /**
     * @author: xiongcong
     * @Date: 2020/2/24 14:44
     * @Description: m 计算
     * <p>
     * 有两种计算中值 m 的方式：
     * <p>
     * m = (l + h) / 2
     * m = l + (h - l) / 2
     * l + h 可能出现加法溢出，也就是说加法的结果大于整型能够表示的范围。
     * 但是 l 和 h 都为正数，因此 h - l 不会出现加法溢出问题。所以，最好使用第二种计算法方法。
     */
    public int binarySearch(int[] nums, int key) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) { // 循环条件 为  <=
            int m = low + (high - low) / 2;
            if (nums[m] == key) {
                return m;
            } else if (nums[m] > key) { //在左半部分
                high = m - 1;
            } else { //在右半部分
                low = m + 1;
            }
        }
        return -1;
    }
}
