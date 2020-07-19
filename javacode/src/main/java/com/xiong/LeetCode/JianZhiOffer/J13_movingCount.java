package com.xiong.LeetCode.JianZhiOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/17 11:13
 * @description：  剑指 Offer 13. 机器人的运动范围  bfs
 * @modified By：
 * @version: $
 */
public class J13_movingCount {

    public int movingCount(int m, int n, int k) {

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0,0});

        visited[0][0] = true;
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int ans = 1;
        while(!q.isEmpty()){

            int[] tmp = q.poll();

            for(int[] d : dir){
                int x = tmp[0] + d[0];
                int y = tmp[1] + d[1];

                if (x >=0 && y >=0 && x < m && y < n && !visited[x][y]
                        && (getSum(x) + getSum(y)) <= k){

                    visited[x][y] = true;
                    ans++;
                    q.offer(new int[]{x, y});
                }
            }

        }

        return ans;

    }

    private int getSum(int n){
        int ans = 0;
        while(n > 0){
            ans  += n % 10;
            n /= 10;
        }
        return ans;
    }
}
