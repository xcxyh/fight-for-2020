package com.xiong.AForkTheWork.HUAWEI;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/12 12:23
 * @description：  0912   一二面
 * @modified By：
 * @version: $
 */
public class Mianshi {




    // 题1
    private static int solve(int[] arr){

        Set<Integer> set = new HashSet<>();

        for (int x : arr) {
            if (!set.contains(x)) {
                set.add(x);
            } else{
                set.remove(x);
            }
        }
        return  set.size();

    }
    private static int solve2(int[] arr, int m){
        int[] bucket = new int[m + 1];
        for (int x : arr) {
            bucket[x]++;
        }
        int count = 0;
        for (int x : bucket) {
            if (x == 1) {
                count++;
            }
        }
        return count;
    }

    private static int solve3(int[] arr, int n,int m){
        Arrays.sort(arr);


        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int x : arr) {
            if (!stack.isEmpty() && stack.peek() == x) {
                stack.pop();
            }

            stack.push(x);
        }

        return stack.size();
    }

    public static void main(String[] args) {

        System.out.println(solve(3,3));

    }
    // 题2   leet62  63
    private static int solve(int m, int n){
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){ dp[i][0] = 1; }
        for (int i = 0; i < n; i++){ dp[0][i] = 1; }
        for (int i = 1; i< m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        for (int i = 0; i< m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m - 1][n - 1];
    }



}
