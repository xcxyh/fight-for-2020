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

    public static boolean duplicate(int[] nums, int length) {
        //边界检查
        if (nums == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            //数组元素和index 不一致
            while (i != nums[i]) {
                //如果该数与 对应的index 上的数相等，证明重复了
                if (nums[i] == nums[nums[i]]) {
                    return true;
                }
                //将数组元素和index 一一对应，如果不对应就交换位置
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return false;
    }
}
