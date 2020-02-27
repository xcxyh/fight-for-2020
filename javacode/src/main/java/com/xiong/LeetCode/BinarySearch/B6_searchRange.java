package com.xiong.LeetCode.BinarySearch;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/25 16:11
 * @description： 给定一个按照升序排列的整数数组 nums，
 * 和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 可以用二分查找找出第一个位置和最后一个位置，
 * 但是寻找的方法有所不同，需要实现两个二分查找。
 * 我们将寻找 target 最后一个位置，
 * 转换成寻找 target+1 第一个位置，再往前移动一个位置。
 * 这样我们只需要实现一个二分查找代码即可。
 * @modified By：
 * @version: $
 */
public class B6_searchRange {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new B6_searchRange().searchRange(new int[]{8,8,8,8,8,9},8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int first = bySearch(nums, target); //下标
        int last = bySearch(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }
    //二分查找变种
    private int bySearch(int[] nums, int target){
        int l = 0, h = nums.length; // 注意 h 的初始值
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
