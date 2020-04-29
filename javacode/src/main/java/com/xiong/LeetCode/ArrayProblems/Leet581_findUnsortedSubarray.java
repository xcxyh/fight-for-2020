package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/22 11:35
 * @description： 581. 最短无序连续子数组  简单？？ 不简单啊
 * @modified By：
 * @version: $
 */
public class Leet581_findUnsortedSubarray {
    //ac  O(n^2) 时间复杂度
    public int findUnsortedSubarray_basic(int[] nums) {
        if (nums == null || nums.length <= 1){
            return 0;
        }
        int len = nums.length;
        int left = len -1;
        int right = 0;
        //双重循环找到 左右两个端点
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1 ; j < len; j++) {
                if (nums[j] < nums[i]){ // 出现逆序
                    left = Math.min(left, i);
                    right = Math.max(right,j);
                }
            }
        }
        return right - left < 0 ? 0 : right - left + 1;
    }

    //ac  O(n) 时间复杂度
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length <= 1){
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 从左向右找到 降序 最小 的元素
        for(int i = 0 ; i < len - 1; i++){
            if (nums[i] > nums[i + 1]){
                min = Math.min(min,nums[i+1]);
            }
        }
        //从右向左找到 升序 最大的元素
        for(int i = len - 1; i >= 1; i--){
            if (nums[i] < nums[i-1]){
                max =Math.max(max,nums[i-1]);
            }
        }
        //从左向右 找到第一个大于 min的元素的位置
        for(int i = 0; i< len; i++){
            if (nums[i] > min){
                left = i;
                break;
            }
        }
        //从右向左 找到第一个小于 max的元素的位置
        for(int i = len - 1; i >= 0; i--){
            if (nums[i] < max){
                right = i;
                break;
            }
        }
        return right <= left ? 0 : right - left + 1;
    }
}
