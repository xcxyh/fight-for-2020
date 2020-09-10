package com.xiong.LeetCode.BackTracking;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/5 12:48
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet60_getPermutation {


    // 回溯
    private String ans = null;
    private int gk = 0;
    private int cnt = 0;
    public String getPermutation(int n, int k) {

        gk = k;

        backtracking(n, new StringBuilder(), new boolean[n + 1]);

        return ans;
    }

    private void backtracking (int n, StringBuilder sb, boolean[] visited) {
        if (sb.length() == n){
            //System.out.print(sb.toString() + " ");
            cnt++;
            if (cnt == gk){
                ans = sb.toString();
            }
            return;
        }
        if (cnt > gk) {
            return;
        }

        for (int i = 1 ; i <= n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            sb.append(i);
            backtracking(n, sb, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}
