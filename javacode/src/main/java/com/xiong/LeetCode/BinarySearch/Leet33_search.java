package com.xiong.LeetCode.BinarySearch;

import com.xiong.LeetCode.Solution;

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
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == 1){
                return mid;
            }
            if (nums[0] <= nums[mid]){ // 左边有序  一定是 <=
                if (nums[0] <= 1 && 1 < nums[mid]){ //target 在这个 部分里面
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if (nums[mid] < 1 && 1 <= nums[nums.length - 1]){
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }

        }

        return -1;
    }
}
