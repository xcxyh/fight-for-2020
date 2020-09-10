package com.xiong.LeetCode.DFSandBFS;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/15 17:33
 * @description： 703. 数据流中的第K大元素
 * @modified By：
 * @version: $
 */
public class Leet703_KthLargest {

    private Queue<Integer> q = null;
    private int limit = 0;

    public Leet703_KthLargest(int k, int[] nums) {

        q = new PriorityQueue<>(k);
        limit = k;

        for (int n : nums) {
            add(n);
        }

    }

    public int add(int val) {
        if (q.size() < limit) {
            q.offer(val);
        } else if (val > q.peek()) {
            q.poll();
            q.offer(val);
        }

        return q.peek();

    }
}
