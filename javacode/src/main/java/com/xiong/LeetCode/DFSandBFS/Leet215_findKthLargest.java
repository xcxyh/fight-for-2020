package com.xiong.LeetCode.DFSandBFS;

import java.util.PriorityQueue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/29 9:38
 * @description： 215. 数组中的第K个最大元素
 * @modified By：
 * @version: $
 */
public class Leet215_findKthLargest {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>(k); // 小顶堆

        int n = nums.length;
        for(int i = 0; i < n; i++){
            if (i < k){
                q.offer(nums[i]);
            }

            if (i >= k && q.peek() < nums[i]){
                q.poll();
                q.offer(nums[i]);
            }

        }

        return q.peek();
    }
}
