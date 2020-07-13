package com.xiong.LeetCode.DailyProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/9 9:16
 * @description：  22. 括号生成
 * 普通的DFS主要用在可达性问题
 * 而Backtracking主要用于求解排列组合问题
 * 本题使用 Backtracking 回溯  JzOffer 38  leetcode 46 相同
 *
 * 39.组合总和
 *
 * 40. 组合总和 II
 *
 * 46. 全排列
 *
 * 47. 全排列 II
 *
 * 78. 子集
 *
 * 90. 子集 II
 *
 * 这类题目都是同一类型的,用回溯算法!
 *
 * 其实回溯算法关键在于:不合适就退回上一步
 *
 * 然后通过约束条件, 减少时间复杂度.
 * @modified By：
 * @version: $
 */
public class D22_generateKuohao {
    public static void main(String[] args) {
        List<String> ans = generateParenthesis(3);
    }

    private static List<String> ans = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return ans;
        }

        backtracking(0, 0, n, new StringBuilder());
        return ans;
    }

    private static void backtracking(int open, int close, int max, StringBuilder sb) {

        if (sb.length() == max * 2) {
            ans.add(sb.toString());
            return;
        }

        if (open < max){
            sb.append('(');
            backtracking(open + 1, close, max, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open){
            sb.append(')');
            backtracking(open, close + 1, max, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    //回溯   另一种写法
    private List<String> ans2 = new ArrayList<>();
    public List<String> generateParenthesis_2(int n) {
        if (n == 0){
            return ans2;
        }
        backtracking(n,n,new StringBuilder());
        return ans2;
    }
    private void backtracking(int left, int right, StringBuilder sb){

        if(left == 0 && right == 0){
            ans2.add(sb.toString());
            return;
        }
        //剪枝
        if (right > left){
            return;
        }

        if(right > 0){
            sb.append('(');
            backtracking(left,right -1,sb);
            sb.deleteCharAt(sb.length() -1);
        }

        if(left > 0){
            sb.append(')');
            backtracking(left - 1,right,sb);
            sb.deleteCharAt(sb.length() -1);
        }
    }
}
