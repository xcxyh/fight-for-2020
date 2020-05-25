package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/20 18:37
 * @description： 面试题53 - I. 在排序数组中查找数字 I
 * @modified By：
 * @version: $
 */
public class J53_search {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = bysearch(nums, target);
        int end = bysearch(nums, target + 1);
        return end - start;
    }

    // 二分
    private int bysearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length; //[  )
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                right = mid; //找到了 去左侧找  直到 找到最左侧的元素, 注意 不要return !!!!
            }
        }
        return left;
    }
}
