package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/24 9:51
 * @description： 4. 寻找两个正序数组的中位数  要求算法的时间复杂度为 O(log(m + n))。
 * @modified By：
 * @version: $
 */
public class Leet4_findMedianSortedArrays {

    // 时间 O(log(m+n)) 空间 不考虑 递归栈  O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;

        if (totalLen % 2 == 0) {
            int left = find(nums1, 0, nums2, 0 , totalLen / 2);
            int right = find(nums1, 0, nums2, 0 , totalLen / 2  + 1);
            return (left + right) / 2.0;
        }else{
            return find(nums1, 0, nums2, 0 , totalLen / 2 + 1);
        }

    }

    private int find(int[] nums1,int i, int[] nums2, int j, int k) {
        // 保证 nums2 一定 长于 nums1
        if (nums1.length - i > nums2.length - j) {
            return find(nums2, j, nums1, i, k);
        }

        if (nums1.length - i == 0) {
            return nums2[j + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }

        int si = Math.min(nums1.length, i + k / 2); int sj = j + k - k / 2;

        if (nums1[si - 1] > nums2[sj - 1]){
            // k - (sj - j) , k 要减去 删除的元素的个数
            return find(nums1, i, nums2, sj, k - (sj - j));
        }else{
            return find(nums1, si, nums2, j, k - (si - i));
        }

    }




    // 时间 O(m+n) 空间 O(1)   时间复杂度 不符合要求
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
