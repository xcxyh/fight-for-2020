package com.xiong.LeetCode.BinarySearch;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/17 9:17
 * @description： 35. 搜索插入位置
 * @modified By：
 * @version: $
 */
public class Leet35_searchInsert {

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        int left = 0;
        int right = nums.length;

        while(left < right){
            int mid = left + (right - left ) / 2;

            if (target > nums[mid]){
                left = mid + 1;
            }else if (target < nums[mid]){
                right = mid;
            }else{
                right = mid;
            }

        }

        return left;
    }
}
