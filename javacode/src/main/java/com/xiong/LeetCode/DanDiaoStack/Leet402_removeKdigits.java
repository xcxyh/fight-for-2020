package com.xiong.LeetCode.DanDiaoStack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/11/17 11:08
 * @description： 402. 移掉K位数字
 * @modified By：
 * @version: $
 */
public class Leet402_removeKdigits {

    public String removeKdigits(String num, int k) {

        if (num == null || num.length() == 0){
            return "0";
        }

        if (num.length() == k){
            return "0";
        }

        // 单调增栈
        StringBuilder sb = new StringBuilder();
        int n = num.length();
        for (int i = 0; i < n; i++){
            char cur = num.charAt(i);
            while ( sb.length() > 0 && sb.charAt(sb.length() - 1) > cur && k > 0){
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(cur);

        }
        // case   "10200", k = 1
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        // case "112" k = 1
        while(k-- > 0){
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
