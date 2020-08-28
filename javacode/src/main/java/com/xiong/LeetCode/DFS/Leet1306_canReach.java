package com.xiong.LeetCode.DFS;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/24 18:56
 * @description： 1306. 跳跃游戏 III
 * @modified By：
 * @version: $
 */
public class Leet1306_canReach {


    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        return dfs(arr, start, new boolean[n]);
    }

    private boolean dfs(int[] arr, int start, boolean[] visited){


        if (start < 0 || start >= arr.length){
            return false;
        }
        // 防止 成环
        if (visited[start]){
            return false;
        }

        if (arr[start] == 0){
            return true;
        }
        visited[start] = true;
        // 当前轮 所能跳到的位置
        int right = start + arr[start];
        int left = start - arr[start];

        return dfs(arr, right, visited) || dfs(arr, left, visited);
    }
}
