package com.xiong.LeetCode.TopologicalSorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/17 9:52
 * @description： 210. 课程表 II
 * @modified By：
 * @version: $
 */
public class Leet210_findOrder {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //以邻接链表构造图

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        //init
        for(int i = 0; i<numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        int[] indegree = new int[numCourses]; //入度
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }
        int[] ans = new int[numCourses];
        int k = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                ans[k++] = i;
                q.offer(i);
            }
        }
        //bfs
        while(!q.isEmpty()){
            int from = q.poll();
            for(int to : graph[from]){
                indegree[to]--;
                if (indegree[to] == 0){
                    ans[k++] = to;
                    q.offer(to);
                }
            }
        }
        boolean flag = true; // 是否有拓扑排序
        for(int n : indegree){
            if (n != 0){
                flag = false;
            }
        }
        return flag ? ans : new int[]{};
    }
}
