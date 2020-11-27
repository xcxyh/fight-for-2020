package com.xiong.LeetCode.DailyProblems;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/11/9 10:10
 * @description： 973. 最接近原点的 K 个点
 * @modified By：
 * @version: $
 */
public class Leet973_kClosest {

    public int[][] kClosest(int[][] points, int K) {

        if (points == null || points.length == 0 || points[0].length == 0){
            return points;
        }

        int len = points.length;

        if (K >= len ){
            return points;
        }

        Queue<int[]> queue = new PriorityQueue<>((b, a) -> (a[0]*a[0] + a[1]*a[1] - b[0]*b[0]- b[1]*b[1]));

        for (int[] point : points){
            if (queue.size()< K){
                queue.offer(point);

            }else{
                queue.offer(point);
                queue.poll();
            }

        }

        int[][] ans = new int[K][2];
        int i = 0;
        while (!queue.isEmpty()) {
            ans[i++] = queue.poll();
        }

        return ans;

    }
}
