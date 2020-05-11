package com.xiong.LeetCode.RaceOfWeek;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/10 12:04
 * @description： leetcode 第  188 场周赛
 * @modified By：
 * @version: $
 */
public class Race_188 {

    // 1
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();

        int k = 1;
        for(int i = 0; i< target.length; i++){
            while (k != target[i]){
                ans.add("Push");
                ans.add("Pop");
                k++;
            }
            ans.add("Push");
            k++;

        }
        return ans;
    }
    //2   直接暴力了
    public int countTriplets(int[] arr) {
        int ans = 0;
        int len = arr.length;
        for(int i = 0; i <len; i++ ){
            for(int j = i + 1; j < len; j++){
                int a = 0;
                int t = i;
                while(t < j){
                    a = a ^ arr[t];
                    t++;
                }
                for(int k = j; k < len; k++){
                    int b = 0;
                    int m = j;
                    while(m <= k){
                        b = b ^ arr[m];
                        m++;
                    }
                    if (a== b){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    //3
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return Math.max(0, minTime(0, graph, hasApple, new boolean[n]) - 2);
    }

    private int minTime(int n, ArrayList<Integer>[] graph, List<Boolean> hasApple, boolean[] visited) {
        if (!visited[n]) {
            visited[n] = true;
            int sum = 0;
            for (int i : graph[n]) {
                sum += minTime(i, graph, hasApple, visited);
            }
            if (sum > 0) {
                return sum + 2;
            } else {
                return hasApple.get(n) ? 2 : 0;
            }
        }
        return 0;
    }

    //4 放弃  以下为大佬的 dp
    public int ways(String[] pizza, int k) {
        Integer[][][] dp = new Integer[pizza.length][pizza[0].length()][k];
        return ways(pizza, 0, 0, k - 1, dp);
    }

    private int ways(String[] pizza, int n, int m, int k, Integer[][][] dp) {
        if (dp[n][m][k] != null) {
            return dp[n][m][k];
        } else if (!ways(pizza, n, pizza.length, m, pizza[0].length())) {
            return 0;
        } else if (k == 0) {
            return 1;
        } else {
            int count = 0;
            for (int i = n + 1; i < pizza.length; i++) {
                if (ways(pizza, n, i, m, pizza[0].length())) {
                    count = (count + ways(pizza, i, m, k - 1, dp)) % 1000000007;
                }
            }
            for (int i = m + 1; i < pizza[0].length(); i++) {
                if (ways(pizza, n, pizza.length, m, i)) {
                    count = (count + ways(pizza, n, i, k - 1, dp)) % 1000000007;
                }
            }
            return dp[n][m][k] = count;
        }
    }

    private boolean ways(String[] pizza, int a, int b, int c, int d) {
        for (int i = a; i < b; i++) {
            for (int j = c; j < d; j++) {
                if (pizza[i].charAt(j) == 'A') {
                    return true;
                }
            }
        }
        return false;
    }
}
