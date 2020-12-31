package com.xiong.LeetCode.BinarySearch;

import java.util.*;

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
     * @Description: 1 寻找一个数（基本的二分搜索）
     * m 计算
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
        int high = nums.length - 1;  // 注意 区间  左闭右闭 [  ]

        while (low <= high) { //   注意 : 循环条件 为  <=
            int m = low + (high - low) / 2;
            if (nums[m] == key) {
                return m;
            } else if (key < nums[m]) { //在左半部分
                high = m - 1;
            } else if (key > nums[m]) { //在右半部分
                low = m + 1;
            }
        }
        return -1;
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
            int mid = l + (r - l + 1) / 2;
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


    public static void main(String[] args) {
        System.out.println(new BinarySearch().findLast(new int[]{8, 8, 8, 8, 10}, 9));
    }


}
