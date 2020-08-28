package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/1 12:31
 * @description： 17. 电话号码的字母组合
 * @modified By：
 * @version: $
 */
public class Leet17_letterCombinations {



    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }

        dfs(digits, 0, new StringBuilder());

        return ans;
    }

    private void dfs(String digits, int cur, StringBuilder sb){
        if (cur == digits.length()){
            ans.add(sb.toString());
            return;
        }

        String str = getLetter(digits.charAt(cur));

        for(int i = 0; i < str.length(); i++){

            sb.append(str.charAt(i));
            dfs(digits, cur + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private String getLetter(char c){
        String str = "";

        switch (c) {
            case '2':
                str = "abc";
                break;
            case '3':
                str = "def";
                break;
            case '4':
                str = "ghi";
                break;
            case '5':
                str = "jkl";
                break;
            case '6':
                str = "mno";
                break;
            case '7':
                str = "pqrs";
                break;
            case '8':
                str = "tuv";
                break;
            case '9':
                str = "wxyz";
                break;
            default:
                break;
        }
        return str;
    }


    List<String> ans1 = new ArrayList<>();
    Map<Character, String> map;
    public List<String> letterCombinations1(String digits) {
        if (digits == null || digits.length() == 0){
            return ans;
        }

        map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        // 回溯
        backtracking(digits, 0, new StringBuilder());
        return ans;

    }

    private void backtracking(String digits, int cur, StringBuilder sb){

        if (cur == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String str = map.get(digits.charAt(cur));

        for(int j = 0; j < str.length(); j++){
            char c = str.charAt(j);
            sb.append(c);
            backtracking(digits, cur + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
