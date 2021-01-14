package com.xiong.LeetCode.DanDiaoStack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/2 11:16
 * @description： 239. 滑动窗口最大值
 * @modified By：
 * @version: $
 */
public class Leet239_maxSlidingWindow {

    //单调双端队列 ， 为了去除左边的最大值，无法使用stack，只能使用双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) { return nums; }
        int n = nums.length;
        LinkedList<Integer> qMax = new LinkedList<>(); // 双向链表 作为 单调双向队列
        int i = 0;
        int[] ans = new int[n - k + 1];
        int j = 0;
        while (i < n) {
            while(!qMax.isEmpty() &&  nums[qMax.peekLast()] <= nums[i]) {
                qMax.pollLast();
            }
            qMax.offer(i);

            if (qMax.peekFirst() <= i - k) {
                qMax.pollFirst();
            }
            if (i >= k - 1) {
                ans[j++] = nums[qMax.peekFirst()];
            }
            i++;
        }
        return ans;
    }
    //分块 + 预处理
    //我们可以将数组 nums 从左到右按照 k 个一组进行分组，最后一组中元素的数量可能会不足 k 个。
    //left[i] 表示下标 i 对应的分组中，以 i 结尾的前缀最大值
    //right[i] 表示下标 i 对应的分组中，以 i 开始的后缀最大值。
    //这种方法与稀疏表（Sparse Table）非常类似
    public int[] maxSlidingWindow_dalao(int[] nums, int k) {
        int len = nums.length;

        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];
        right[len - 1] = nums[len - 1];

        for (int i = 1; i < len; i++) {
            if (i % k == 0) {
                left[i] = nums[i];
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            int j = len - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }
        int[] res = new int[len - k + 1];
        for (int i = 0; i <= len - k; i++) {
            res[i] = Math.max(left[i + k - 1], right[i]);
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return res;
    }
}
