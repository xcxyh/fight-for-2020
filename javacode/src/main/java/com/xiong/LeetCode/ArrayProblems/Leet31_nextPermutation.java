package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/3 21:08
 * @description： 31. 下一个排列  倒序遍历 +  部分翻转 +  交换
 * @modified By：
 * @version: $
 */
public class Leet31_nextPermutation {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for(int i = n - 1; i > 0; i--){
            if (nums[i] > nums[i - 1]){
                // 先反
                reverse(nums, i);

                for (int j = i; j < n; j++){
                    if (nums[j] > nums[i - 1]){
                        //再交换
                        swap(nums,i - 1, j);
                        return;
                    }
                }

            }
        }

        // 反序整个 数组
        reverse(nums, 0);

    }

    // 反转 部分数组， 传入 数组 和起点
    private void reverse(int[] nums, int start){
        int n = nums.length;
        int curLen = n - start;
        for(int i = start; i < start +  curLen / 2; i++){

            swap(nums,i , start + n - 1 - i);
        }
    }

    private void swap(int[] nums, int a ,int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
