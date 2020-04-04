package com.xiong.LeetCode.DailyProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/1 16:10
 * @description：  1111. 有效括号的嵌套深度
 * @modified By：
 * @version: $
 */
public class D1111_maxDepthAfterSpilt {


    public int[] maxDepthAfterSplit(String seq) {
        //默认合法
        //计算 栈的深度
        int[] ans = new int[seq.length()];
        int  depth = 0;
        int i  = 0 ;
        for(char c : seq.toCharArray()){
            if (c == '('){
                ans[i++] = depth % 2; // 深度的奇偶 分开 即为答案
                depth ++; // 左括号深度加1
            }else{
                depth --;
                ans[i++] = depth % 2;
            }
        }

        return ans;
    }
}
