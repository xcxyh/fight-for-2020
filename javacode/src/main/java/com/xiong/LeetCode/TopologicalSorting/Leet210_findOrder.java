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

    //dfs
    boolean valid = true; // 检测是否成环
    ArrayList<Integer>[] graph;
    int[] visited; // 记录节点的状态 0 未搜索， 1 搜索中， 2 搜索完

    int[] result; // 结果集， 倒着存入元素
    int index; // 结果集 下标
    public int[] findOrder_dfs(int numCourses, int[][] prerequisites) {
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

        result = new int[numCourses];

        index = numCourses - 1;

        for(int i = 0; i < numCourses && valid; i++){
            if (visited[i] == 0){
                dfs(i);
            }
        }
        // 只要不成环 就有拓扑排序

        if (index != -1){
            return new int[]{};
        }

        return result;
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
        result[index--] = i;
    }



    //bfs
    private int[] findOrder(int numCourses, int[][] prerequisites) {
        //以邻接链表构造图

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        //init
        for(int i = 0; i<numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[numCourses]; //入度
        for (int[] edge : prerequisites) {
            graph[edge[1]].add(edge[0]);
            indegree[edge[0]]++;
        }
        int[] ans = new int[numCourses];
        int k = 0;
        Queue<Integer> q = new LinkedList<>();
        // 首先入队 所有入度为 0 的 点
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
        // 是否有拓扑排序
        boolean flag = true;
        // 存在入度 不为 0 的点 证明没有拓扑排序
        for(int n : indegree){
            if (n != 0){
                flag = false;
            }
        }
        return flag ? ans : new int[]{};
    }
}
