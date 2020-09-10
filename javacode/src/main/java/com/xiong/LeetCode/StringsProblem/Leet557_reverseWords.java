package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/30 8:32
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet557_reverseWords {


    public String reverseWords(String s) {
        int n = s.length();

        int i = 0;
        int j = 0;

        char[] chs = s.toCharArray();
        while(j < n){
            while(j < n &&  chs[j] == ' '){
                j++;
            }
            i = j;
            while( j < n && chs[j] != ' '){
                j++;
            }

            reverse(chs, i, j - 1);

        }

        return new String(chs);
    }

    private void reverse(char[] chs, int i , int j){

        while(i < j){
            char c = chs[i];
            chs[i] = chs[j];
            chs[j] = c;
            i++;
            j--;
        }
    }
}
