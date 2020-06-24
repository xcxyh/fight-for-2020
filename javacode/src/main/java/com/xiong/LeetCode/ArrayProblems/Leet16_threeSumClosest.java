package com.xiong.LeetCode.ArrayProblems;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/24 10:00
 * @description：  16. 最接近的三数之和
 * @modified By：
 * @version: $
 */
public class Leet16_threeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int gap = Integer.MAX_VALUE;
        for(int i = 0; i < n - 2; i++){
            int first = nums[i];

            int left = i + 1;
            int right = n - 1;
            while(left < right){
                int sum = first + nums[left] + nums[right];

                if (sum < target){
                    left++;
                }else if (sum > target){
                    right--;
                }else{
                    return target;
                }
                int temp = Math.abs(sum - target);
                if ( temp < gap){
                    gap = temp;
                    ans = sum;
                }

            }
        }

        return ans;
    }
}
