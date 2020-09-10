package com.xiong.LeetCode.DP_memo;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/31 15:33
 * @description：  不一定对， 自己写的，题目就是那张图
 * @modified By：
 * @version: $
 */
public class TriangleMAx {

    private static void second() {

        int[][] arr = new int[][]{{3}, {5, 9, 4}, {5, 2, 1, 3, 9}, {3, 7, 2, 8, 4, 2, 6}};

        System.out.println(getMax(4, arr, 0, 0));
    }

    private static int getMax(int n, int[][] arr, int curIndex, int curLevel) {

        if (curLevel >= n) {
            return 0;
        }

        int sum = 0;

        sum += arr[curLevel][curIndex];

        curLevel++;

        curIndex ++;

        int left = getMax(n, arr, curIndex - 1, curLevel);
        int mid = getMax(n, arr, curIndex, curLevel);
        int right = getMax(n, arr, curIndex + 1, curLevel);

        sum += Math.max(left, Math.max(mid, right));


        return sum;
    }
}
