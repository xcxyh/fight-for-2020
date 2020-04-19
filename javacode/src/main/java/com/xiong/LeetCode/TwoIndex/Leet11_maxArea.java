package com.xiong.LeetCode.TwoIndex;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/18 8:22
 * @description：  11. 盛最多水的容器，可与 leetCode42_trap 比较 ：42. 接雨水
 * @modified By：
 * @version: $
 */
public class Leet11_maxArea {

    public int maxArea(int[] height) {
        //双指针法
        int len = height.length;
        int ans = 0;

        int left = 0;
        int right = len -1;
        while(left < right){
            int square = (right - left) * Math.min(height[left],height[right]);
            ans = Math.max(ans,square);
            //移动低的那个柱子的 指针
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }

    private int violenceMethod(int[] height){
        int len = height.length;
        int max = 0;
        //暴力法
        for(int i =0; i<len; i++){
            for(int j = i+1; j<len; j++){
                int temp = Math.min(height[i],height[j]);
                temp = temp * (j - i);
                max = Math.max(max,temp);
            }
        }
        return max;
    }
}
