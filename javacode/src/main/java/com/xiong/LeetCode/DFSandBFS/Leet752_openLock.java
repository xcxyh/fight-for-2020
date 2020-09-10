package com.xiong.LeetCode.DFSandBFS;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/19 15:10
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet752_openLock {

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }
    // bfs 基础版本  可以有其他的优化方式  如双向遍历等
    public static int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        int[] lock = new int[4];
        //Set  标记已经遍历了的情况
        Set<String> visited = new HashSet<>(); // 不加这个绝对超时
        Queue<int[]> q = new LinkedList<>();
        int ans = 0;
        q.offer(lock);
        while (!q.isEmpty()) {
            int size = q.size();//用于分层
            while (size-- > 0) {
                int[] temp = q.poll();
                String tempStr  = arrToString(temp);
                if (target.equals(tempStr)) {
                    return ans;
                } else if (!dead.contains(tempStr)) {
                    //尝试 +
                    for (int i = 0; i < 4; i++) {
                        int[] next = Arrays.copyOf(temp, 4);
                        next[i] = (next[i] + 1) > 9 ? 0 : next[i] + 1;
                        String nextstr = arrToString(next);
                        if(!visited.contains(nextstr)){
                            visited.add(nextstr);
                            q.offer(next);
                        }
                    }
                    //尝试 -
                    for (int i = 0; i < 4; i++) {
                        int[] next = Arrays.copyOf(temp, 4);
                        next[i] = (next[i] - 1) < 0 ? 9 : next[i] - 1;
                        String nextstr = arrToString(next);
                        if(!visited.contains(nextstr)){
                            visited.add(nextstr);
                            q.offer(next);
                        }
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    // 将 [1,0,0,0] -----> "0001"
    private static String arrToString(int[] lock) {
        if (lock == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        //倒着
        for (int i = lock.length - 1; i >= 0; i--) {
            sb.append(lock[i]);
        }
        return sb.toString();
    }
}
