package com.xiong.LeetCode.TopologicalSorting;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/17 10:27
 * @description：  207. 课程表
 *    dfs  或者是  通过 BFS 统计入度 来 判断 有向图中是否有循环
 * @modified By：
 * @version: $
 */
public class Leet207_canFinish {

    //bfs  计算入度的方式 写法较简单
    public boolean canFinish_bfs(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        int[] indegrees = new int[numCourses];

        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
            indegrees[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        // 入队 入度为0 的点
        for(int i = 0; i < numCourses; i++){
            if (indegrees[i] == 0){
                q.offer(i);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int from = q.poll();
            for(int to : graph[from]){
                indegrees[to]--;
                if (indegrees[to] == 0){
                    q.offer(to);
                }
            }
        }

        boolean valid = true;

        for(int x : indegrees){
            if (x != 0){
                valid = false;
                break;
            }
        }
        return valid;
    }


    // dfs
    boolean valid = true; // 检测是否成环
    ArrayList<Integer>[] graph;
    int[] visited; // 记录节点的状态 0 未搜索， 1 搜索中， 2 搜索完

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构造 graph
        graph = new ArrayList[numCourses];

        //init
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
        }

        visited = new int[numCourses];

        for(int i = 0; i < numCourses && valid; i++){
            if (visited[i] == 0){
                dfs(i);
            }
        }
        // 只要不成环 就有拓扑排序
        return valid;
    }
    private void dfs(int i){

        visited[i] = 1;
        for(int n : graph[i]){

            if (visited[n] == 0){
                dfs(n);
                if (!valid) {
                    return;
                }
            }
            if (visited[n] == 1 ){
                valid = false;
                return;
            }
        }

        visited[i] = 2;
    }
}
