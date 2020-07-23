package com.xiong.LeetCode.TwoIndex;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/20 11:10
 * @description： 167. 两数之和 II - 输入有序数组
 * @modified By：
 * @version: $
 */
public class Leet167_twoSum {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0){
            return new int[]{};
        }

        int n = numbers.length;

        int left = 0;
        int right = n -1;
        while(left < right){

            int sum = numbers[left] + numbers[right];

            if (sum < target){
                left++;
            }else if (sum > target){
                right--;
            }else{
                return new int[]{left+1, right+1};
            }

        }

        return new int[]{};
    }
}
