package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/3 21:08
 * @description： 31. 下一个排列  倒序遍历 +  部分翻转 +  交换
 * @modified By：
 * @version: $
 */
public class Leet31_nextPermutation {

    // 官方
    public void nextPermutation1(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int n = nums.length;
        int i = n - 2;
        // 从后向前查找
        while (i >=0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >=0){
            int j = n - 1;
            while (j > i && nums[j] <= nums[i]){
                j--;
            }
            //交换 i 和 j 位置的元素
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        //翻转 j+1 , n
        reverse(nums, i + 1, n - 1);

    }
    private void reverse(int[] nums, int start, int end) {
        while( start < end){
            int t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }





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
