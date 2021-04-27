package com.xiong.LeetCode.BinarySearch.旋转数组二分;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/27 11:02
 * @description：  33. 搜索旋转排序数组
 * @modified By：
 * @version: $
 */
public class Leet33_search {

    public static void main(String[] args) {
        System.out.println(new Leet33_search().search(new int[]{3, 1}, 1));

    }

    private int search(int[] nums, int target) {
        // 复杂度 logn
        // 但数组部分有序 二分 分成两部分  判断哪部分有序
        // 若 target 在这个有序的部分中 ，则 缩小范围 到 这一部分
        // 否则 缩小范围 到 另一部分
        //二分 查找
        int n = nums.length;

        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = n - 1;
         // <= 细节!!!
        while (l <= r) {
            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            // <= 细节!!!
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
