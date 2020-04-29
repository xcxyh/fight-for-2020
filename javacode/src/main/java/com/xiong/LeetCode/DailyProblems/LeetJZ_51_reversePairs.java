package com.xiong.LeetCode.DailyProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/24 10:17
 * @description： 面试题51. 数组中的逆序对
 * <p>
 * 正确解法：  利用归并排序。。。。
 * @modified By：
 * @version: $
 */
public class LeetJZ_51_reversePairs {

    /**
     *  @author: xiongcong
     *  @Date: 2020/4/24 12:54
     *  @Description:  利用归并排序 合并过程中 计算逆序度
     *
     *  比归并排序 多 2 句 代码
     */
    // 不要用 static  不然 leetcode 中为 静态成员变量  会累加多个测试用例的结果
    private int[] temp; // 辅助数组 放在 merge 外面
    private int count = 0;
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);

        return count;
    }

    //归并排序
    private void mergeSort(int[] arr, int left, int right) {
        if (right <= left) {
            return;
        }

        int mid = left + (right - left) / 2;
        //拆分
        mergeSort(arr, left, mid);
        //拆分
        mergeSort(arr, mid + 1, right);
        //合并
        merge(arr, left, mid, right);

    }

    //合并
    private void merge(int[] arr, int left, int mid, int right) {

        int i = left; // 左的起点
        int j = mid + 1; // 右的起点
        int k = left; // 临时数组的 起点 ！！！！ 不要设置为 0
        //合并
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
                k++;
                //arr[i] <= arr[j]  证明从 mid+1 到 j 个数  不包括 j 位置本身 小于 arr[i]
                count += j - (mid + 1); // 这时计算 逆序度
            } else {
                temp[k] = arr[j];
                j++;
                k++;
                // 或者
                // count += mid - i + 1;
            }
        }

        // 当 左边还有剩余
        while (i <= mid) {
            count += j - (mid + 1);// 计算 逆序度
            temp[k++] = arr[i++];
        }
        // 当 右边还有剩余
        while (j <= right) {
            temp[k++] = arr[j++];
            // 或者
            // count += mid - i + 1;
        }

        //从temp 到 arr
        while (left <= right) {
            arr[left] = temp[left];
            left++;
        }

    }


    //超时了  O(n^2)时间复杂度
    public int reversePairs_basic(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int len = nums.length;
        //  O(n^2)  2* 10^9 超时了
        int count = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i - 1]) {
                    count++;
                }
            }
        }
        return count;
    }

}
