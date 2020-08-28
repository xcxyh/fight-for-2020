package com.xiong.LeetCode;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/19 9:38
 * @description：
 * @modified By：
 * @version: $
 */
public class Solution {
    public static void main(String[] args) {
        // solve(6, new String[]{"1 0 3", "3", "1 1 4", "3", "2 0", "3"});
        //second();
    }


    private static void second() {

        int[][] arr = new int[][]{{3}, {5, 9, 4}, {5, 2, 1, 3, 9}, {3, 7, 2, 8, 4, 2, 6}};

        System.out.println(getMax(4, arr, 0, 0));
    }

    private static int getMax(int n, int[][] arr, int curIndex, int curLevel) {

        if (curLevel >= n) {
            return 0;
        }

        int sum = 0;

        sum += arr[curLevel][curIndex];

        curLevel++;

        curIndex ++;

        int left = getMax(n, arr, curIndex - 1, curLevel);
        int mid = getMax(n, arr, curIndex, curLevel);
        int right = getMax(n, arr, curIndex + 1, curLevel);

        sum += Math.max(left, Math.max(mid, right));


        return sum;
    }


    private static void solve(int m, String[] strs) {

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            String s = strs[i];

            String[] ss = s.split(" ");

            if (Integer.valueOf(ss[0]) == 1) {
                int a = Integer.valueOf(ss[1]);
                int b = Integer.valueOf(ss[2]);
                list.add(a, b);
            } else if (Integer.valueOf(ss[0]) == 2) {
                int a = Integer.valueOf(ss[1]);
                list.remove(a);
            } else {
                print(list);
            }
        }

    }


    private static void print(LinkedList<Integer> list) {
        if (list.size() == 0) {
            System.out.println();
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int x : list) {
            sb.append(x).append(" ");
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}