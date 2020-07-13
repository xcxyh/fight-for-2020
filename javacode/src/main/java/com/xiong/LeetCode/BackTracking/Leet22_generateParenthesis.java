package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/28 17:11
 * @description： 22. 括号生成
 * @modified By：
 * @version: $
 */
public class Leet22_generateParenthesis {

    private List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0){
            return new ArrayList<>();
        }
        backtracking(0, 0, n, new StringBuilder());
        return ans;
    }

    private void backtracking(int left, int right, int n , StringBuilder sb){

        if(left == n && right == n){
            ans.add(sb.toString());
            return ;
        }
        // 右括号 个数 大于 左括号 ，不合法 ))()
        if (right > left){
            return;
        }

        if (left < n){
            sb.append('(');
            backtracking(left + 1, right , n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (right < n){
            sb.append(')');
            backtracking(left, right + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
