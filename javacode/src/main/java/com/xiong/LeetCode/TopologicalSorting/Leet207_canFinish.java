package com.xiong.LeetCode.TopologicalSorting;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/17 10:27
 * @description：  207. 课程表
 *    dfs  或者是  通过 BFS 统计入度 来 判断 有向图中是否有循环
 * @modified By：
 * @version: $
 */
public class Leet207_canFinish {

    // dfs
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        //init
        for(int i = 0; i< numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]);
        }
        int[] isVisited = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if (!dfs(graph, i, isVisited)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int cur, int[] isVisited){
        if(1 == isVisited[cur]){
            return true;
        }

        if (-1 == isVisited[cur]){
            return false;
        }
        isVisited[cur] = -1;
        for(int to : graph.get(cur)){
            if(!dfs(graph, to, isVisited)){
                return false;
            }
        }
        isVisited[cur] = 1;
        return true;

    }
}
