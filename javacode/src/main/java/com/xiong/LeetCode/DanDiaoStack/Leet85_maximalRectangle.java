package com.xiong.LeetCode.DanDiaoStack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/26 11:45
 * @description： 85. 最大矩形
 * @modified By：
 * @version: $
 */
public class Leet85_maximalRectangle {

    // 暴力优化 ，先 计算出所有 当前点  左边连续 1 的个数 （包括自己），即矩形的宽
    // 再 依次 比较 所有 以 当前点作为 右下角的矩形的面积，取最大的
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        int[][] left = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                left[i][j] = matrix[i][j] - '0';
                if (j > 0 && matrix[i][j] == '1') {
                    left[i][j] += left[i][j-1];
                }
                // System.out.print(left[i][j] + " ");
            }
            //System.out.println();
        }
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (left[i][j] == 0){
                    continue;
                }
                int temp = left[i][j];
                int min = left[i][j];
                for (int k = i - 1; k >= 0; k--){
                    min = Math.min(min, left[k][j]);
                    temp = Math.max(temp, (i - k + 1) * min);
                }
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }

    // 单调栈，先求出每层的 heights 数组， 再调用 84 题 单调栈解法，取 所有层结果的最大值
    public int maximalRectangle2(char[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // 这里 heights 数组的大小 与列数相等
        int[] heights = new int[col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cur = matrix[i][j] - '0';
                if (cur == 1) {
                    heights[j] += 1;
                }else{
                    heights[j] = 0;
                }
            }

            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }


    private int largestRectangleArea(int[] heights){

        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int h = 0;
        int ans = 0;
        for (int i = 0; i <= n; i++) {

            if (i == n) {
                h = -1;
            }else{
                h = heights[i];
            }

            while (!stack.isEmpty() && h <= heights[stack.peek()]) {
                int leftindex = stack.pop();
                int height = heights[leftindex];
                int width = i;
                if (!stack.isEmpty()) {
                    width = i - stack.peek() - 1;
                }
                ans = Math.max(ans, width * height);
            }

            stack.push(i);
        }

        return ans;

    }

}
