package com.xiong.AForkTheWork.Baidu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/03 22:03
 * @description：
 * @modified By：
 * @version: $
 */
public class BiShi0903 {

    // 题1
    public static void first() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(solve1(n, arr));
    }

    private static String solve1(int n, int[] arr) {

        int count0 = 0;
        int count5 = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                count0++;
            } else {
                count5++;
            }
        }
        if (count0 == 0) {
            return "-1";
        }
        if (count5 == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        int k = count5 / 9;
        for (int i = 0; i < k; i++) {
            sb.append("555555555");
        }
        for (int i = 0; i < count0; i++) {
            sb.append("0");
        }

        return sb.toString();
    }


    // 题2
    public static void second() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<int[][]> inlist = new ArrayList<>();
            int k = 0;
            for (int j = 0; j < m; j++) {
                k = sc.nextInt();
                int[][] interval = new int[k][2];
                for (int z = 0; z < k; z++) {
                    interval[z][0] = sc.nextInt();
                    interval[z][1] = sc.nextInt();
                }
                inlist.add(interval);
            }
            solve(n, m, inlist);
        }

    }

    private static void solve(int n, int m, List<int[][]> inlist) {
        int count = 0;
        // 求区间交集
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int tempc = 0;
            for (int j = 0; j < m; j++) {
                int[][] interval = inlist.get(j);
                for (int z = 0; z < interval.length; z++) {
                    if (i >= interval[z][0] && i <= interval[z][1]) {
                        tempc++;
                        break;
                    }
                }
            }
            if (tempc == m) {
                count++;
                sb.append(i).append(" ");
            }

        }

        System.out.println(count);
        System.out.println(sb.toString().substring(0, sb.length() - 1));
    }


    // 题3
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(solve(n, m, 0, 0));
    }

    private static int solve(int n, int m, int pre, int prepre) {
        int mod = 1000000007;
        if (n == 0) {
            return 1;
        }

        int count = 0;
        if (n >= m) {
            for (int i = 1; i <= m; i++) {
                if (i == pre || i == prepre) {
                    continue;
                }

                count += solve(n - i, m, i, pre) % mod;
            }
        } else {
            count = solve(n, n, pre, prepre) % mod;
        }

        return count;
    }

}
