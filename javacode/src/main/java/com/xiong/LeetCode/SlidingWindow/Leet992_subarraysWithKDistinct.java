package com.xiong.LeetCode.SlidingWindow;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/9 9:08
 * @description：992. K 个不同整数的子数组  [left1  left2] ... right
 * @modified By：
 * @version: $
 */
public class Leet992_subarraysWithKDistinct {


    public int subarraysWithKDistinct(int[] A, int K) {
        int n = A.length;
        // 计数
        int[] arr1 = new int[n + 1];
        int[] arr2 = new int[n + 1];
        // 记录不同整数个数
        int cnt1 = 0, cnt2 = 0;

        int left1 = 0, left2 = 0, right = 0;
        int ans = 0;
        while ( right < n) {
            // 有不同 + 1
            if (arr1[A[right]] == 0) {
                cnt1++;
            }
            arr1[A[right]]++;
            if (arr2[A[right]] == 0) {
                cnt2++;
            }
            arr2[A[right]]++;
            // 左端点区间的 左端
            while (cnt1 > K) {
                arr1[A[left1]]--;
                if (arr1[A[left1]] == 0) {
                    cnt1--;
                }
                left1++;
            }
            // 左端点区间的 右端
            while (cnt2 > K - 1) {
                arr2[A[left2]]--;
                if (arr2[A[left2]] == 0) {
                    cnt2--;
                }
                left2++;
            }

            ans += left2 - left1;
            right++;

        }

        return ans;
    }
}
