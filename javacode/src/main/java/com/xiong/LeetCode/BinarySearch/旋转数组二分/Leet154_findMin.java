package com.xiong.LeetCode.BinarySearch.旋转数组二分;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/8 10:27
 * @description： 154. 寻找旋转排序数组中的最小值 II
 * @modified By：
 * @version: $
 */
public class Leet154_findMin {

    public int findMin(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[l] == nums[m] && nums[m] == nums[r]) {
                r--;
                l++;
            }else {
                // 与右端点比较
                if (nums[m] > nums[r]) {
                    l = m + 1;
                }else {
                    r = m;
                }
            }

        }

        return nums[l];
    }
    // 与左端点比较
    public int findMin_cmpWithLeft(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = n - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (nums[l] == nums[m] && nums[m] == nums[r]) {
                r--;
                l++;
            }else {
                // 与 左端点 比较 要先判断是否有序
                if (nums[r] > nums[l]) {
                    return nums[l];
                }
                // 这里是 >= !!!
                if (nums[m] >= nums[l]) {
                    l = m + 1;
                }else {
                    r = m;
                }
            }

        }

        return nums[l];
    }
}
