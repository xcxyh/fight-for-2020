package com.xiong.LeetCode.JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/16 16:13
 * @description：   面试题38. 字符串的排列  与 47. 全排列 II  Leet47_permuteUnique 做法一致
 * @modified By：
 * @version: $
 */
public class J38_permutation {

    public static void main(String[] args) {
        new J38_permutation().permutation("abc");
    }


    public String[] permutation(String s) {

        if (s == null || s.length() == 0){
            return new String[]{s};
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        Arrays.sort(chars); // 排序！！！！！！！！
        List<String> ans = new ArrayList<>();
        backtracking(chars, new StringBuilder(), new boolean[n], ans);
        return ans.toArray(new String[0]);
    }

    private void backtracking(
            char[] chars, StringBuilder sb,boolean[] visited, List<String> ans){

        if (sb.length() == chars.length){
            ans.add(sb.toString());
            return;
        }

        for(int i = 0; i < chars.length; i++){
            if (visited[i]){
                continue;
            }
            // 剪枝去重 这个剪枝操作的前提是 对 chars 数组进行排序
            if (i > 0  && !visited[i-1] && chars[i] == chars[i - 1]){
                continue;
            }

            sb.append(chars[i]);
            visited[i] = true;
            backtracking(chars, sb, visited, ans);
            sb.deleteCharAt(sb.length() - 1);  // 这里也忘了
            visited[i] = false;

        }


    }


}
