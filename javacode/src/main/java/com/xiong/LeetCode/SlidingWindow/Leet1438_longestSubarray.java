package com.xiong.LeetCode.SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/21 11:50
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1438_longestSubarray {

    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;

        int left = 0, right = 0;

        int ans = 0;
        // Deque 双端队列
        Deque<Integer> qMin = new LinkedList<>();
        Deque<Integer> qMax = new LinkedList<>();
        while (right < n) {
            // right 这边添加删除元素 所以 pollLast  offerLast
            while (!qMin.isEmpty() && qMin.peekLast() > nums[right]) {
                qMin.pollLast();
            }

            while (!qMax.isEmpty() && qMax.peekLast() < nums[right]) {
                qMax.pollLast();
            }

            qMin.offerLast(nums[right]);
            qMax.offerLast(nums[right]);
            // left 这边删除元素 所以 pollFirst
            while (!qMin.isEmpty() && !qMax.isEmpty()
                    && qMax.peekFirst() - qMin.peekFirst() > limit) {

                if (nums[left] == qMin.peekFirst()) {
                    qMin.pollFirst();
                }

                if (nums[left] == qMax.peekFirst()) {
                    qMax.pollFirst();
                }

                left++;

            }
            right++;
            ans = Math.max(ans, right - left);

        }

        return ans;
    }
}
