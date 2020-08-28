package com.xiong.AForkTheWork.MeiTuan;

import com.xiong.LeetCode.Solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/10 18:17
 * @description： 8.8笔试
 * @modified By：
 * @version: $
 */
public class WrittenExam {

    public static void main(String[] args) {

       new WrittenExam().solve(5, new int[][]{
                {1,2,3},
                {1,3,1},
                {1,4,2},
                {2,5,1}
        });

    }

    //4
    // 利用栈，贪心的做法 , [2, 1, 1 ,2 ,3, 4] 这个样例就过不了
    //nums = [1,1,1,1,1]
    //nums = [2, 2, 2, 3]
    // 应该用 区间dp 的方式
    //dp[i][j][k]  表示 从 i 到 j 这个区间 能否合并出 数 k
    public int merge(int[] nums) {

        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int x : nums) {
            if (!stack.isEmpty() && stack.peek() == x) {
                int t = stack.pop();
                int nt = t + 1;
                ans++;
                while (!stack.isEmpty() && stack.peek() == nt) {
                    t = stack.pop();
                    nt = t + 1;
                    ans++;
                }
                stack.push(nt);
            } else {
                stack.push(x);
            }

        }
        return ans;
    }


    //3
    private int[] distArr;
    private int[] roadArr;
    private int k = 0;
    private void solve(int n, int[][] arr) {
        //
        ArrayList<int[]>[] graph = new ArrayList[n + 1];

        //
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            graph[arr[i][0]].add(new int[]{arr[i][1], arr[i][2]});
        }
        distArr = new int[n + 1];
        roadArr = new int[n];
        dfs(graph, 1);

        int distSum = 0;
        for(int x : distArr){
            distSum += x;
        }
        int minDist = 0;
        int max = 0;
        for (int x : roadArr){
            if (max < x){
                max = x;
            }
            minDist += x * 2;
        }
        System.out.println(distSum);
        System.out.println(minDist - max);

    }

    private void dfs(ArrayList<int[]>[] graph, int start) {
        if (graph[start].size() == 0){
            roadArr[k++] = distArr[start];
        }
        for (int[] to : graph[start]) {

            distArr[to[0]] = distArr[start] + to[1];

            dfs(graph, to[0]);
        }
    }

    //4
    private static void solve(int n, int[] arr) {

        int[] bucket = new int[500];

        for (int x : arr) {
            bucket[x]++;
        }
        int ans = 0;

        for (int i = 0; i < 500; i++) {
            int count = bucket[i] / 2;
            ans += count;

            bucket[i] = bucket[i] % 2;
            if (count != 0) {
                bucket[i + 1] += count;
            }
        }

        System.out.println(ans);
    }

    //2
    private static void payMin(int n, int[][] arr) {
        int shouldSum = 0;
        int realSum = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] > arr[i][1]) {
                shouldSum += arr[i][0];
                realSum += arr[i][1];
            } else {
                shouldSum += arr[i][1];
            }
        }
        System.out.println(shouldSum + " " + realSum);
    }

    //1
    private void average() {
        Scanner scanner = new Scanner(System.in);
        long val = 0;
        int count = 0;
        for (int i = 0; i < 5; i++) {
            int ac = scanner.nextInt();
            count += ac;
            val += ac * (i + 1);
        }
        double v = ((double) val) / count;
        System.out.println(Math.floor(v * 10) / 10);
    }


    //5
    //第五题，一棵树，有n个节点，分黄色和黑色的，
    // 问你，每个节点t为根的子树，忽略同色节点，求树的深度（高度），
    // 就是最底下的异色节点离t有多远。
    public static void slove5() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Tree[] trees = new Tree[n + 1];
        for (int i = 1; i <= n; i++) {
            trees[i] = new Tree(i, scanner.nextInt() != 1);
        }
        for (int i = 1; i <= n - 1; i++) {
            trees[scanner.nextInt()].sons.add(trees[i + 1]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(trees[i].calcDepth(0, trees[i].yellow)).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static class Tree {
        ArrayList<Tree> sons;

        int id;
        boolean yellow;

        public Tree(int id, boolean yellow) {
            this.id = id;
            this.yellow = yellow;
            this.sons = new ArrayList<>();
        }

        public int calcDepth(int already, boolean initialColor) {
            int myDepth;
            if (this.yellow == initialColor) {
                myDepth = 0;
            } else
                myDepth = already;
            for (Tree son : sons) {
                myDepth += son.calcDepth(already + 1, initialColor);
            }
            return myDepth;
        }
    }

}


