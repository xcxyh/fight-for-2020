package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/11/30 16:19
 * @description： 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * Output:
 * 2
 * 要求时间复杂度 O(N)，空间复杂度 O(1)。
 *
 * 思路： 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
 *
 * 对于数组元素在长度范围内的题，可以考虑 数组元素和下标index 一一对应的方法来处理。
 * @modified By：
 * @version: $
 */
public class J03_DuplicateNum {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 3, 1, 0, 2, 5};
        System.out.println(duplicate(nums, nums.length));
    }

    private static int duplicate(int[] nums, int length) {
        //边界检查
        if (nums == null || length <= 0) {
            return -1;
        }
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i){
                if (nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                //交换
                int temp = nums[i];
                nums[i] = nums[temp]; // 不要写 nums[nums[i]] 容易死循环
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
