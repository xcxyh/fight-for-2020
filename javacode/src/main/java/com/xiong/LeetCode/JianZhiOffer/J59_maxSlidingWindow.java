package com.xiong.LeetCode.JianZhiOffer;

import java.util.LinkedList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/21 17:22
 * @description： 面试题59 - I. 滑动窗口的最大值
 * @modified By：
 * @version: $
 */
public class J59_maxSlidingWindow {
    // 保证在 O(n) 的时间复杂度 ，即为困难题
    //单调双向队列  保证 以队头为下标的元素 为最大元素
    public int[] maxSlidingWindow_queue(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        int index = 0;
        LinkedList<Integer> qMax = new LinkedList<>(); // 双向链表 作为 单调双向队列

        for (int i = 0; i < len; i++) {
            // 保证队列中元素的单调性
            // 在队列不为空的情况下，如果队列尾部的元素要比当前的元素小，或等于当前的元素
            // 那么为了维持从大到小的原则，我必须让尾部元素弹出
            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[i] ){
                qMax.pollLast();
            }
            //正常在队列尾部添加元素
            qMax.addLast(i);
            //如果滑动窗口已经略过了队列中头部的元素，则将头部元素弹出!!!!
            if (qMax.peekFirst() == (i - k)) {
                qMax.pollFirst();
            }
            // 看看窗口有没有形成，只有形成了大小为 k 的窗口，我才能收集窗口内的最大值
            if (i >= (k - 1)){
                ans[index++] = nums[qMax.peekFirst()];
            }
        }
        return ans;
    }


    //暴力法
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        for (int i = 0; i < len - k + 1; i++) {
            ans[i] = nums[i];
            for (int j = i + 1; j < i + k; j++) {
                ans[i] = Math.max(ans[i], nums[j]);
            }
        }
        return ans;
    }
}
