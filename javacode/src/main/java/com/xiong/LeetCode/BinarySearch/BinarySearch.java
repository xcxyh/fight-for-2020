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

    /**
     * @author: xiongcong
     * @Date: 2020/2/25 16:38
     * @Description: 2 寻找左侧边界的二分搜索
     * 用途广泛
     * 二分查找变种  若未找到 则返回 可以插入的位置
     * 若找到 则返回 该元素在数组中的最左位置
     */
    public int binarySearch_2(int[] nums, int key) {
        int l = 0;

        int h = nums.length; // 注意 区间  左闭右开 [  )

        while (l < h) { //  注意 :  循环条件 为  <
            int m = l + (h - l) / 2;

            if (key == nums[m]) {
                h = m; // 找到了 去左侧找  直到 找到最左侧的元素
                // 例如 ： [1,2,2,2,3]  找到 了 中间的2 之后 不返回
                // 去左侧区间，[1, 2, 2) 就 可以找到最左的索引为 1 的元素 2
            } else if (key < nums[m]) {
                h = m; // 去左侧区间
            } else if (key > nums[m]) {
                l = m + 1;// 去右侧 区间 ，此时 左闭右开 而 m 已经判断过了
                // 直接从 m + 1 开始
            }
        }
        // 未找到key时，返回的是 可以插入的位置  
        return l; // 此时 l == r  返回哪个都可以

        //若要返回 -1 则改造为 如下代码：
//        if (left == nums.length) return -1;   // target 比所有数都大
//        return nums[left] == target ? left : -1;

    }

    /**
     * @author: xiongcong
     * @Date: 2020/5/9 9:45
     * @Description: 3  寻找右侧边界的二分查找
     */
    public int binarySearch_3(int[] nums, int key) {

        int left = 0;
        int right = nums.length; // 还是 左闭右开

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (key == nums[mid]) {
                left = mid + 1;  // 注意 不要立即返回，而是增大「搜索区间」的下界 left
            } else if (key < nums[mid]) {
                right = mid;
            } else if (key > nums[mid]) {
                left = mid + 1;
            }
        }

        return left - 1; // 注意

        // 如果 找不到 要返回 -1, 改为如下：
//        if (left == 0) return -1;
//        return nums[left-1] == key ? (left-1) : -1;
    }


    public static void main(String[] args) {
        System.out.println(new BinarySearch().binarySearch_2(new int[]{8, 8, 8, 8, 10}, 9));
    }


}
