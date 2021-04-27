package com.xiong.LeetCode.ArrayProblems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/3/24 10:25
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet456_find132pattern {


    public boolean find132pattern(int[] nums) {
        int n = nums.length;

        int[] mins = new int[n];

        mins[0] = nums[0];

        for (int i = 1; i < n; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i]);
        }

        Deque<Integer> stack = new ArrayDeque<>();
        // 枚举3 从后往前
        for (int i = n - 1; i >= 0; i--) {

            if (nums[i] > mins[i]) {
                // 保证栈中每一个元素都是大于 mins[i]
                while ( !stack.isEmpty() && stack.peek() <= mins[i]) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }

                stack.push(nums[i]);
            }

        }

        return false;

    }
}
