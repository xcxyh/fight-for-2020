package com.xiong.LeetCode.TwoIndex;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/21 10:23
 * @description： 1248. 统计「优美子数组」
 * @modified By：
 * @version: $
 */
public class Leet1248_numberOfSubarrays {

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 1, 1, 2, 2, 2}, 2)); //12
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //双指针法
        // 1 找到 奇数个数为k 的最小区间 即 两端都是 奇数
        // 2 统计 子数组中第一个奇数前面的连续 偶数 个数
        // 3 最后结果还要加上  区间前面偶数个数 * 区间后面偶数个数
        int left = 0;
        int right = 0;
        int len = nums.length;
        int ans = 0;
        int preEven = 0; //第一个奇数前面的偶数的个数

        int count = 0; // 连续子数组中奇数的个数
        while (right < len) {
            if (count < k) {
                if (nums[right] % 2 == 1) {
                    count++;
                }
                right++;
            }

            if (count == k) {
                preEven = 0;
                while (count == k) {
                    ans++;
                    if (nums[left] % 2 != 0) {
                        count--;
                    }
                    left++;
                    preEven++;
                }
            } else {
                ans += preEven; // 每次遇到 right 为偶数的时候就进行累加 相当于区间前面偶数个数 * 后面偶数个数
            }
        }
        return ans;
    }

}
