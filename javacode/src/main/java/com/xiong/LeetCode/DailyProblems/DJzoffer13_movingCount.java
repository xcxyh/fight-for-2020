package com.xiong.LeetCode.DailyProblems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/8 19:08
 * @description：  JzOffer 第 13 题 机器人的运动范围
 * @modified By：
 * @version: $
 */
public class DJzoffer13_movingCount {
    public static void main(String[] args) {
        System.out.println(movingCount(50, 50, 18)); //2200
    }

    public static int movingCount(int m, int n, int k) {
        if (k == 0){
            return 1;
        }
        //BFS
        // 从左上角到 右下角  则只需 尝试 右下  两个方向
        int[][] dir = new int[][]{{1,0},{0,1}};
        boolean[][] isVisited = new boolean[m][n];  //避免重复访问同一个位置
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int ans = 0;
        //模板代码start
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            ans++;
            for(int[] d : dir){
                int x = temp[0] + d[0];
                int y =  temp[1] + d[1];
                if(x < m && y < n && (getSum(x)+ getSum(y)) <= k && !isVisited[x][y]){ // 关键条件
                    queue.offer(new int[]{x,y});
                    isVisited[x][y] = true;
                }
            }
        }
        //模板代码end
        return ans;
    }

    private static int getSum(int n){
        int ans = 0;
        if(n == 0){
            return ans;
        }
        while(n > 0){
            ans += n % 10;
            n = n / 10;
        }
        return ans;
    }
}
