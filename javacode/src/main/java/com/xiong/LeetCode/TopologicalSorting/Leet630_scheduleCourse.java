package com.xiong.LeetCode.TopologicalSorting;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/4 10:26
 * @description： 630. 课程表 III     优先队列 ，不是 拓扑排序
 * @modified By：
 * @version: $
 */
public class Leet630_scheduleCourse {

    public int scheduleCourse(int[][] courses) {
        // 按 右端点排序
        Arrays.sort(courses, (a , b) -> (a[1] - b[1]));

        PriorityQueue<Integer> q = new  PriorityQueue<>((a, b) -> (b - a));

        int timeSum = 0;
        for(int[] p : courses){
            if (timeSum + p[0] <= p[1]){
                q.offer(p[0]);
                timeSum += p[0];
            }else if (! q.isEmpty() && q.peek() > p[0]){
                timeSum -= q.poll();
                timeSum += p[0];
                q.offer(p[0]);
            }
        }
        return q.size();
    }
}
