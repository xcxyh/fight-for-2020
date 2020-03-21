package com.xiong.LeetCode.ArrayProblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/20 14:14
 * @description 输入整数数组 arr ，找出其中最小的 k 个数。
 * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * @modified By：
 * @version: $
 */
public class A40_getLeastNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getLeastNumbers_heap(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4)));
    }
    //冒泡。。。
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }

        int len = arr.length;
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < len ; j++) {
                if (arr[i] > arr[j]){
                    swap(arr,i,j);
                }
            }
        }
        return Arrays.copyOf(arr, k);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    //桶排序  初始化 一个 大小 10001 的数组


    //堆排序 用大顶堆
    public  static int[] getLeastNumbers_heap(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        //大顶堆 堆顶元素最大
        for (int num: arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (!pq.isEmpty() && num < pq.peek()) { //有元素比堆顶小时
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for(int num: pq) {
            res[idx++] = num;
        }
        return res;
    }

    //利用快排思想。。。
}
