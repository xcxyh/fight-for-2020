package com.xiong.nowCoder;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/13 21:55
 * @description：
 * @modified By：
 * @version: $
 */
public class nowCoder_2 {
    //1
    //链接：https://ac.nowcoder.com/acm/contest/6911/A
    //来源：牛客网
    //
    //题目描述
    //给你一个正整数n，重复进行以下操作：
    //1.如果n是奇数，令n=n-3n=n−3
    //2.如果n是偶数，令n=n/2n=n/2
    //重复上述直至n=0停止，请输出进行操作的次数，如果n永远无法变成零，输出-1
    public int Numberofoperations(long n) {
        // write code here
        int ans = 0;
        while (n != 0) {
            if (n == 1) {
                return -1;
            }
            if (n % 2 == 1) {
                n = n - 3;
            } else {
                n = n / 2;
            }
            ans++;
        }
        return ans;
    }

    //2
    //链接：https://ac.nowcoder.com/acm/contest/6911/B
    //来源：牛客网
    //
    //题目描述
    //牛牛最近迷上了小游戏，于是他也想对他的01字符串进行一些操作，
    // 01字符串上的0和0相邻时会变成1，而1和1相邻时会在字符串上消失，
    // 而0和1相邻时什么都不会发生，牛牛现在把初始的字符串给你，
    // 你能告诉牛牛这个字符串最后会变成什么样吗
    public String solve(String s) {
        // write code here
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == '0' && stack.peek() == '0') {
                stack.pop();
                if (!stack.isEmpty() && stack.peek() == '1') {
                    stack.pop();
                } else {
                    stack.push('1');
                }
            } else if (!stack.isEmpty() && c == '1' && stack.peek() == '1') {
                stack.pop();
            } else {
                stack.push(c);
            }

        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    //3
    //链接：https://ac.nowcoder.com/acm/contest/6911/C
    //来源：牛客网
    //
    //题目描述
    //题意
    //集合 ss 中有整数 11 到 nn，牛牛想从中挑几个整数组成一个新的集合。
    //
    //现在牛妹给牛牛加了 mm 个限制 ，每个限制包含两个整数 uu 和 vv ( u\neq vu
    //
    //​
    // =v)，且 uu 和 vv 不能同时出现在新集合中 。
    //
    //请问牛牛能组成的新集合多少种。
    //
    //可以选 0 个数
    //
    //输入
    //第一个参数为 nn。
    //
    //第二个参数为 mm 。
    //
    //第三个参数为 mm 对 (u, v) 。
    //
    //1 < n \leq 20 \quad 1\leq m \leq 400\quad 1 \leq u, v\leq n1<n≤201≤m≤4001≤u,v≤n
    //
    //返回
    //
    //一个整数，即新集合的种类数。
    public class Point {
        int x;
        int y;
    }


    public int solve(int n, int m, Point[] limit) {
        // write code here
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            map.put(i, new HashSet<>());
        }
        for (Point point : limit) {
            map.get(point.x).add(point.y);
            map.get(point.y).add(point.x);
        }
        return backTrack(n, new LinkedList<>(), map);
    }

    public int backTrack(int n, LinkedList<Integer> list, Map<Integer, Set<Integer>> map) {
        if (n == 0) {
            return 1;
        }
        int count1 = backTrack(n - 1, list, map);
        for (int i : list) {
            if (map.get(i).contains(n)) {
                return count1;
            }
        }
        list.add(n);
        int count2 = backTrack(n - 1, list, map);
        list.removeLast();
        return count1+count2;
    }

    public static long numbers (int a, int b, int c, int d, int p) {
        // write code here
        long c1 = b / p - (a - 1) / p;
        long c2 = d / p - (c - 1) / p;
        return c1 *(d -c + 1) + c2 *(b -a + 1) - c1 * c2;
    }
}
