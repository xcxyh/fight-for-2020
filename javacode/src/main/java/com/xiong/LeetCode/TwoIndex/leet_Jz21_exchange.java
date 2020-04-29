package com.xiong.LeetCode.TwoIndex;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/28 8:35
 * @description： 面试题21. 调整数组顺序使奇数位于偶数前面
 * @modified By：
 * @version: $
 */
public class leet_Jz21_exchange {

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length <= 1){
            return nums;
        }
        // 首尾双指针 判断
        int left = 0;
        int right = nums.length -1;

        while(left < right){
            if ( (nums[left] & 1) == 0 && (nums[right] & 1) == 1){ // 左为偶数 右为奇数 交换
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                right--;
                left++;
            }else if ((nums[left] & 1) == 1){ // 否则 ，左为奇数 就向后移动一位
                left++;
            }else if ((nums[right] & 1) == 0){// 否则 ，右为偶数 就向前移动一位
                right--;
            }

        }
        return nums;

    }
}
