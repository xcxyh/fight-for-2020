package com.xiong.SortAlgorithm;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/20 17:49
 * @description： 二叉堆实现 堆排序, 一般升序排序采用大顶堆
 * @modified By：
 * @version: $
 */
public class HeapSort {
    /**
     * @author: xiongcong
     * @Date: 2020/6/20 18:06
     * @Description: 堆排序的基本思想是：将待排序序列构造成一个大顶堆，
     * 此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，
     * 此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，
     * 这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
     */
    public static void main(String[] args) {
        int[] arr = {25,84,21,47,15,27,68,35,20};
        new HeapSort().heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //1 将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
    //1.1 从最后一个非叶子结点开始 第一个非叶子结点下标 x = len / 2 - 1
    // 怎么算的呢？
    // len 为奇数 则右叶子节点存在，2*x + 2 = len - 1 ----> x = (len - 1)/2 -1
    // len 为偶数 则右叶子节点不存在， 2*x + 1 = len - 1 ----> x = len / 2 - 1
    //又因为 当 len 为奇数时， len/2 的 取整结果 即为 (len - 1)/ 2
    // 综合两种情况， 可以得到 x = len / 2 - 1

    public int[] heapSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 堆排序
        int n = nums.length;
        // 建堆， 大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjust(nums, i, n);
        }
        // 排序
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, 0, i);
            // 调整
            adjust(nums, 0, i);
        }

        return nums;
    }
    // 前提是  arr 在调整之前基本是一个 大顶堆，即除了 当前元素 ，其他 元素都在合适的位置上
    // 调整大顶堆 将 arr 中 从 i 到 curLen 的所有元素调整为 一个大顶堆
    // 该函数只是 将 位置 i 的元素放到了 大顶堆的 合适的位置，
    // arr  当前节点下标  当前堆的长度。 复杂度  logn
    private void adjust(int[] nums, int cur, int curLen) {

        // 从 左子节点开始
        while (2 * cur + 1 < curLen) {
            int i = 2 * cur + 1;
            // 若有右子节点 则判断是否大于 左
            if (i + 1 < curLen && nums[i] < nums[i + 1]) {
                i++;
            }

            if (nums[i] > nums[cur]) {
                swap(nums, i, cur);
            } else {
                break;
            }

            cur = i;
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
