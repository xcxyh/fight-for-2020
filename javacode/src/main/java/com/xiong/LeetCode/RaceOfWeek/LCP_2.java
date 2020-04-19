package com.xiong.LeetCode.RaceOfWeek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/19 8:13
 * @description：
 * @modified By：
 * @version: $
 */
public class LCP_2 {

    public static void main(String[] args) {
        System.out.println(numWays_dp(5,new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}},3));
    }

    //题1 LCP 06. 拿硬币
    public int minCount(int[] coins) {
        int ans = 0;
        for(int i = 0; i< coins.length; i++){
            int temp = coins[i];
            int yu = temp % 2 ;
            ans += temp / 2 + yu;
        }
        return ans;
    }

    //题2 LCP 07. 传递信息
    // 大佬的 dp  。。。状态转移 。。。
    public static int numWays_dp(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        //dp[i][j] 表示 第 i 轮转移后 以上一轮中的状态为起点 能到达 j 的 方案次数
        for(int i = 0; i < k; i++){
            for(int[] r : relation){
                dp[i + 1][r[1]] += dp[i][r[0]];
            }
        }
        return dp[k][n - 1];
    }
    //我的 dfs
    private static int ans = 0;
    public static int numWays(int n, int[][] relation, int k) {
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for(int[] arr : relation){
            List<Integer> list = graph.get(arr[0]);
            if (list == null){
                list = new ArrayList<>();
            }
            list.add(arr[1]);
            graph.put(arr[0],list);
        }
        dfs(0,graph,k,n-1);
        return ans;

    }
    private static void dfs(int pos, Map<Integer,List<Integer>> graph, int k, int target){
        if (pos == target && k == 0){
            ans++;
            return;
        }
        if(k <0){
            return;
        }
        List<Integer> list = graph.get(pos);
        if (list == null){
            return;
        }
        k--;//!!!!!!!
        for(int next : list){
            dfs(next,graph,k,target);
        }
    }




    //题4 LCP 09. 最小跳跃次数
    public int minJump(int[] jump) {
        int len = jump.length;
        int[] dp = new int[len];

        //dp[i] 表示 从 位置 i 向右跨越所需 最小次数
        for(int i = len - 1; i >= 0 ; i--){
            dp[i] = jump[i] + i >= len ? 1 : dp[jump[i] + i] + 1;

            //更新, i 位置 右边 都可以跳回到i 位置,
            //如果  dp[j] >= dp[i] + 1 则更新，否则不更新
            for(int j = i + 1; j < len && dp[j] >= dp[i] + 1 ; j++){
                dp[j] =dp[i] + 1;
            }
        }
        return dp[0];
    }

}
