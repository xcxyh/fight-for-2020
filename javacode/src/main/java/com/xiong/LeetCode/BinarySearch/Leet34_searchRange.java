package com.xiong.LeetCode.BinarySearch;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/2 10:19
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet34_searchRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }

        int left = findFirst(nums, target);

        if (left == -1){
            return new int[]{-1, -1};
        }

        int right = findLast(nums, target);

        return new int[]{left, right};

    }
    // 找左边界
    private int findFirst(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;

        while ( l < r){
            int mid = l + (r - l) / 2;
            if (nums[mid] < target){
                l = mid + 1;
            }else if (nums[mid] == target){
                r = mid;
            }else{
                r = mid - 1;
            }

        }

        if (nums[l] == target){
            return l;
        }

        return -1;
    }
    //找右边界
    private int findLast(int[] nums, int target){
        int l = 0;
        int r = nums.length - 1;

        while ( l < r){
            int mid = l + (r - l + 1) / 2;  // 这里要加 1
            if (target < nums[mid]){
                r = mid - 1;
            }else if (target == nums[mid]){
                l = mid;
            }else{
                l = mid + 1;
            }

        }

        return l;
    }
}
