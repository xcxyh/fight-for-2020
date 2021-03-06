package com.xiong.JZOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/1/3 10:23
 * @description： 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @modified By：
 * @version: $
 */
public class J13_MovingCount {

    public static void main(String[] args) {
        System.out.println(movingCount(50, 50, 18)); //2200
    }
    // BFS
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
