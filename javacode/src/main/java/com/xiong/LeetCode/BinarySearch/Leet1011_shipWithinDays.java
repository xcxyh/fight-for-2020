package com.xiong.LeetCode.BinarySearch;

import java.util.Random;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/4/26 10:29
 * @description：  1011. 在 D 天内送达包裹的能力  得到目标值边界（最大，最小），然后在这个边界内二分
 * @modified By：
 * @version: $
 */
public class Leet1011_shipWithinDays {

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{10,50,100,100,50,100,100,100},5));
    }

    private static int shipWithinDays(int[] weights, int D) {
        //  二分 子数组和最大 最小

        int left = 0;
        int right = 0;
        for (int x : weights) {
            if (x > left) {
                left = x;
            }
            right += x;
        }
        // 寻找左边界的 二分
        while (left < right) {

            int mid = left + (right - left) / 2;

            int group = getGroup(weights, mid);
            if (group > D) {
                left = mid + 1;
            }else{
                right = mid;
            }
        }

        return left;
    }

    private static int getGroup(int[] weights, int maxWeight) {

        int group = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {

            if (sum + weights[i] <= maxWeight) {
                sum += weights[i];
            }else{
                group += 1;
                sum = weights[i];
            }

        }
        return group;
    }
}
