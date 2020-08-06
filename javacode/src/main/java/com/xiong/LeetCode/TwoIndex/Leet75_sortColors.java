package com.xiong.LeetCode.TwoIndex;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/1 20:23
 * @description： 75. 颜色分类  荷兰国旗问题，   计数排序 或者 p0 p2 cur 指针 移动
 * @modified By：
 * @version: $
 */
public class Leet75_sortColors {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }

        int n = nums.length;
        int p0 = 0;
        int p2 = n - 1;
        int cur = 0;

        while(cur <= p2){
            if (nums[cur] == 0){
                swap(nums, cur, p0);
                cur++;
                p0++;
            }else if (nums[cur] == 2){ // cur 指向 2时 不移动 cur ，只交换
                // 这里不要 cur++;
                swap(nums, cur, p2);
                p2--;
            }else{
                cur++;
            }

        }


    }

    private void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
