package com.xiong.LeetCode.RaceOfWeek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/31 13:11
 * @description：  第 191 场周赛
 * @modified By：
 * @version: $
 */
public class Race_191 {

    // 1 5424. 数组中两元素的最大乘积
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                ans = Math.max(ans, (nums[i]-1)*(nums[j]-1));
            }
        }
        return ans;
    }
    //2 5425. 切割后面积最大的蛋糕
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // 最大间隔相乘
        int mod = 1000000007;
        long maxh = 0;
        long maxv = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long firsth = (horizontalCuts[0] - 0)% mod;
        long lasth = (h - horizontalCuts[horizontalCuts.length - 1])% mod;
        maxh = Math.max(maxh, Math.max(firsth, lasth));

        for(int i = 1; i < horizontalCuts.length; i++){
            long temp = (horizontalCuts[i] - horizontalCuts[i-1])% mod;
            maxh = Math.max(maxh, temp);
        }
        // System.out.println(maxh);
        long firstv = (verticalCuts[0] - 0)% mod;
        long lastv = (w - verticalCuts[verticalCuts.length - 1])% mod;
        maxv = Math.max(maxv, Math.max(firstv, lastv));

        for(int i = 1; i < verticalCuts.length; i++){
            long temp = (verticalCuts[i] - verticalCuts[i-1])% mod;
            maxv = Math.max(maxv, temp);
        }
        //System.out.println(maxv);
        maxh = maxh % mod;
        maxv = maxv % mod;
        return (int) (maxh * maxv % mod);

    }
    //3  5426. 重新规划路线
    public int minReorder(int n, int[][] connections) {
        ArrayList<int[]>[] list = new ArrayList[n];
        //init
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int[] c : connections){
            list[c[0]].add(new int[]{c[1], 1}); // 原图中有向边 为 1
            list[c[1]].add(new int[]{c[0], 0}); // 与原图相反的有向边， 即原图中不存在的有向边  权值为 0
        }

        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        q.offer(0);
        visited[0] = true;
        while(! q.isEmpty()){
            int temp = q.poll();
            for(int[] t : list[temp]){ // 从 0 出发 bfs 遍历 整个图 ，则 可以得到 所有 远离 0 的 有向边的 权值之和
                // 即为答案
                if (!visited[t[0]]){

                    visited[t[0]] = true; //标记已访问的 点
                    ans += t[1];
                    q.offer(t[0]);
                }
            }
        }
        return ans;
    }

    //4  5427. 两个盒子中球的颜色数相同的概率  72 人通过  72 / 3686

}
