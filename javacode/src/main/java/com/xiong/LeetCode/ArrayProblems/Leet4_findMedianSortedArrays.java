package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/24 9:51
 * @description： 4. 寻找两个正序数组的中位数  要求算法的时间复杂度为 O(log(m + n))。
 * @modified By：
 * @version: $
 */
public class Leet4_findMedianSortedArrays {

    // 时间 O(m+n) 空间 O(1)
    public double findMedianSortedArrays_2(int[] nums1, int[] nums2) {
        int m = nums1 == null ? 0 : nums1.length;
        int n = nums2 == null ? 0 : nums2.length;

        int left = -1; // 用于记录 中位数前一个数
        int right = -1;// 用于记录 中位数

        int len = m + n;
        int acur = 0; int bcur = 0;
        for (int i = 0; i <= len / 2 ; i++){ // 走到中间
            left = right;
            if (acur < m   &&  (bcur >= n || nums1[acur] < nums2[bcur])){
                right = nums1[acur];
                acur++;
            }else if (bcur < n){
                right = nums2[bcur];
                bcur++;
            }
        }

        if ((len & 1) == 0){
            return (left + right) / 2.0;
        }else{
            return right;
        }

    }

    //此方法不符合题目要求
    // 合并为一个 有序数组 ，二路归并，然后得到中位数  时间 O(m+n) 空间 O(m+n)
    public double findMedianSortedArrays_3(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
            return 0.0;
        }
        int m = nums1 == null ? 0 : nums1.length;
        int n = nums2 == null ? 0 : nums2.length;
        int[] ans = new int[m + n];

        int count = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                ans[count++] = nums1[i];
                i++;
            } else {
                ans[count++] = nums2[j];
                j++;
            }
        }
        while (i < m) {
            ans[count++] = nums1[i++];
        }
        while (j < n) {
            ans[count++] = nums2[j++];
        }
        if (count % 2 == 0) {
            return (ans[count / 2 - 1] + ans[count / 2]) / 2.0;
        } else {
            return ans[count / 2];
        }
    }



}
