package com.xiong.AForkTheWork.WangYi;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/12 17:10
 * @description：
 * @modified By：
 * @version: $
 */
public class WitternExams {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        solve(arr, N);
    }


    //3
    private static int slove(int n, int[][] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();


        int ans = 0;
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][2] == 0) {
                if (!stack.isEmpty()) {
                    int pre = stack.peek();
                    map.put(pre, map.get(pre) + arr[i][0]);
                }

                stack.push(arr[i][1]);
                map.put(arr[i][1], -arr[i][0]);

            } else if (arr[i][2] == 1 && stack.peek() == arr[i][1]) {
                int key = stack.pop();
                int val = arr[i][0] + map.get(key);
                map.put(key, val);
                if (!stack.isEmpty()) {
                    int pre = stack.peek();
                    map.put(pre, map.get(pre) - arr[i][0]);
                }

                if (val > maxTime) {
                    maxTime = val;
                    ans = key;
                } else if (val == maxTime) {
                    if (ans > key) {
                        ans = key;
                    }
                }

            }
        }

        return ans;
    }


    //2
    public static void solve(int[][] arr, int N) {
        if (N == 1) {
            System.out.println("1 1");
            return;
        }
        int[] rows = new int[N];
        int[] cols = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rows[i] += arr[i][j];
                cols[i] += arr[j][i];
            }
        }
        int max = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int val = rows[i] + cols[j] - arr[i][j];
                if (val > max) {
                    max = val;
                    row = i;
                    col = j;
                }
            }
        }
        row++;
        col++;
        System.out.println(row + " " + col);

        int[][] arr_next = new int[N - 1][N - 1];
        int k = 0;
        for (int i = 0; i < N; i++) {
            if (row - 1 != i) {
                int m = 0;
                for (int j = 0; j < N; j++) {
                    if (col - 1 != j) {
                        arr_next[k][m] = arr[i][j];
                        m++;
                    }
                }
                k++;
            }
        }
        solve(arr_next, N - 1);
    }

    //1
    private static String calcu(String str) {
        String[] strs = str.split(" ");

        Set<Integer> nums = new HashSet<>();
        int n = strs.length;

        int wan = 0;
        int bin = 0;
        int tiao = 0;
        for (int i = 0; i < n; i++) {
            String temp = strs[i];
            int x = temp.charAt(0) - '0';
            nums.add(x);

            if (temp.charAt(1) == 'W') {
                wan++;

            } else if (temp.charAt(1) == 'T') {
                tiao++;

            } else {
                bin++;
            }
        }

        if (nums.size() < 7) {
            return "NO";
        }
        if (wan > 4 || wan == 0) {
            return "NO";
        }
        if (bin > 4 || bin == 0) {
            return "NO";
        }
        if (tiao > 4 || tiao == 0) {
            return "NO";
        }

        return "YES";

    }
}
