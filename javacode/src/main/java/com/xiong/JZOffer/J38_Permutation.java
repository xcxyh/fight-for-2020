package com.xiong.JZOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/6 18:15
 * @description： 字符串的排列  回溯算法  有点难啊
 *    与   leetcode 46  相同， 与  leetcode 22 相似
 * @modified By：
 * @version: $
 */
public class J38_Permutation {

    public static void main(String[] args) {
            Permutation("abc");
    }


    private static ArrayList<String> ret = new ArrayList<>();
    public static ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0){
            return ret;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        //回溯
        backtracking(chars,new boolean[chars.length],new StringBuilder());

        return ret;
    }

    private static void backtracking(char[] chars, boolean[] isUsed, StringBuilder sb){
        int len = chars.length;
        if(sb.length() == len){
            ret.add(sb.toString());
            return;
        }

        for(int i = 0; i< len; i++){
            if (isUsed[i]){
                continue;
            }
            if (i != 0 && chars[i] == chars[i - 1] && !isUsed[i - 1]){ //？？
                continue;
            }
            //回溯部分start
            sb.append(chars[i]);
            isUsed[i] = true;
            backtracking(chars,isUsed,sb);
            sb.deleteCharAt(sb.length() - 1);
            isUsed[i] = false;
            //回溯部分end
        }

    }
}
