package com.xiong.LeetCode.GreedyAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/9/19 10:31
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet921_minAddToMakeValid {


    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        int needleft = 0;
        int needright = 0;
        int n = S.length();
        for (int i = 0;i < n; i++) {
            char c = S.charAt(i);
            if (c  == '(') {
                needright++;
            }
            if (c == ')') {
                needright--;
                if (needright == -1){
                    needleft++;
                    needright = 0;
                }
            }
        }
        return needleft + needright;
    }

}
