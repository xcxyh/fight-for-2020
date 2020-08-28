package com.xiong.nowCoder;

import com.xiong.AForkTheWork.MeiTuan.Main;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/11 9:47
 * @description：
 * @modified By：
 * @version: $
 */
public class ByteDance_1 {

    public static void main(String[] args) {
        System.out.println(new ByteDance_1().getMaxNum(new int[]{1,1,2,4,4,4,5,7,7}, 3));
    }

    private int getMaxNum(int[] nums, int k){

        Arrays.sort(nums);

        int n = nums.length;
        int left = 1;
        int right = n / k;

        while(left < right){

            int mid = left + (right - left) / 2;
            int group = getGroup(nums, mid);
            if (group >= k){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return left;

    }

    private int getGroup(int[] nums, int m){
        int ans = 0;
        for(int i = 0; i < nums.length; i = i + m){
            if (i + m >= nums.length){
                break;
            }

            for (int j = i; j < i + m - 1; j++ ) {
                if (nums[j + 1] - nums[j] > 2){
                    ans--;
                    break;
                }
            }
            ans++;
        }
        return ans;
    }

}
