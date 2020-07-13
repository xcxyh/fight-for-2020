package com.xiong.LeetCode.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/30 8:44
 * @description： 84. 柱状图中最大的矩形  单调增栈
 * @modified By：
 * @version: $
 */
public class Leet84_largestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        //单调栈
        if (heights == null || heights.length == 0){
            return 0;
        }
        // 下标 入栈
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = heights.length;
        int ans = 0;
        for(int i = 0; i <= n; i++){
            int nowheight  = -1;
            if (i < n){
                nowheight = heights[i];
            }
            while(!stack.isEmpty() && nowheight <=  heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = i;
                if (!stack.isEmpty()){
                    width = width - stack.peek() - 1;
                }
                ans = Math.max(ans, width* height);
            }
            stack.push(i);
        }

        return ans;
    }

    private int baoli(int[] heights){
        if (heights == null || heights.length == 0){
            return 0;
        }
        int len = heights.length;
        int square = 0;
        for(int i = 0; i < len; i++ ){
            int curHigh = heights[i];
            int curKuan = 1;
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && heights[left--] >= curHigh){
                curKuan++;
            }
            while (right < len && heights[right++] >= curHigh){
                curKuan++;
            }
            square = Math.max(square, curHigh * curKuan);

        }
        return square;
    }

    // 单调增栈  来 记录 当前元素 左右 的 第一个小于当前元素的元素的下标
    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }
        //单调栈 递增 严格递增  不能有 相同元素
        Deque<Integer> upstack = new ArrayDeque<>();  //存下标

        int len = heights.length;
        int[] left = new int[len];//存下标
        int[] right = new int[len];//存下标
        int square = 0;
        for(int i = 0; i < len; i++){
            while(!upstack.isEmpty() && heights[i] <= heights[upstack.peek()]){
                upstack.pop();
            }
            left[i] = upstack.isEmpty() ? -1 : upstack.peek();  //左边元素全部比当前元素大 则为 -1
            upstack.push(i);
        }

        upstack.clear();
        for(int i = len - 1; i >= 0; i--){
            while(!upstack.isEmpty() && heights[i] <= heights[upstack.peek()]){
                upstack.pop();
            }
            right[i] = upstack.isEmpty() ? len : upstack.peek();  // 右边元素全部比当前元素大则为 len
            upstack.push(i);
        }

        for(int i = 0; i < len; i++){
            square = Math.max(square, (right[i] - left[i] - 1) * heights[i]);
        }

        return square;
    }

}
