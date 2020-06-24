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
        int[] arr = {9, 8, 7, 6, 3, 4, 5, 2, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //堆排序
    private static int[] heapSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int len = arr.length;
        //1 将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;

        //1.1 从最后一个非叶子结点开始 第一个非叶子结点下标 x = len / 2 - 1
        // 怎么算的呢？
        // len 为奇数 则右叶子节点存在，2*x + 2 = len - 1 ----> x = (len - 1)/2 -1
        // len 为偶数 则右叶子节点不存在， 2*x + 1 = len - 1 ----> x = len / 2 - 1
        //又因为 当 len 为奇数时， len/2 的 取整结果 即为 (len - 1)/ 2
        // 综合两种情况， 可以得到 x = len / 2 - 1
        for (int i = len / 2 - 1; i >= 0; i--) {
            //1.2 从下至上 ，从左至右调整
            adjustHeap(arr, i, len);
        }

        //4 重复执行 2 3 两步，直至 整个数组有序
        for (int j = len - 1; j >= 0; j--) {
            //2 将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
            swap(arr, 0, j);
            //3 对剩下的 cur_len - 1 个元素 调整成一个 大顶堆 或小顶堆;
            adjustHeap(arr, 0, j);
        }

        return arr;
    }
    // 前提是  arr 在调整之前基本是一个 大顶堆，即除了 当前元素 ，其他 元素都在合适的位置上
    // 调整大顶堆 将 arr 中 从 i 到 curLen 的所有元素调整为 一个大顶堆
    // 该函数只是 将 位置 i 的元素放到了 大顶堆的 合适的位置，
    private static void adjustHeap(int[] arr, int i, int curLen) {
        int cur = arr[i];
        // cur的左子节点 下标为 2*i + 1
        // cur的右子节点 下标为 2*i + 2
        for (int k = 2 * i + 1; k < curLen; k++) {// 从 左子节点 开始
            // 找出 两个子节点（如果存在）中较大的那个
            if (k + 1 < curLen && arr[k] < arr[k + 1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            //较大的那个子节点 比 根节点 要大
            if (arr[k] > cur){
                arr[i] = arr[k]; //将子节点值赋给父节点（不用进行交换）
                i = k;
            }else{
                break;
            }

        }

        arr[i] = cur;//将 cur 值放到最终的位置

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
