package com.xiong.LeetCode.BinarySearch;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/24 16:26
 * @description： 寻找旋转排序数组中的最小值
 * <p>
 * 二分查找
 * nums[m] > nums[m+1] 时 nums[m+1] 为 最小元素
 * @modified By：
 * @version: $
 */
public class B5_findMin {
    //二分法 （难）
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) { //？？
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    //普通方法
    public int findMinNormal(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) return nums[i];
        }
        return nums[0];
    }
}
