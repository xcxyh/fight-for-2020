package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/1 14:18
 * @description： 剑指 Offer 20. 表示数值的字符串  要考虑多种情况 的题目
 *     最为复杂的 是  小数点 位置的处理
 * @modified By：
 * @version: $
 */
public class J20_isNumber {
    // 能 ac  1481 个 用例
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        char[] chars = s.trim().toCharArray();
        int n = chars.length;
        // 去掉了前后空格之后 为 "" 的情况， 这里 错一次
        if (n == 0){
            return false;
        }

        int i = 0;
        int dot = 1; // 小数点 可以当作一个数字 但是只能出现一次
        // 错了 6 次  以下情况没考虑到
        //".1"  "3." "+.8"  "46.e3" 都可以
        // "+." 不行
        while( i < n){
            //以-  +  . 数字 开头
            if (chars[i] == '+' || chars[i] == '-'
                    || chars[i] == '.' || Character.isDigit(chars[i])){
                // 以-， +， 开头
                if (chars[i] == '+' || chars[i] == '-' ){
                    ++i;
                    // 以-， +， 开头 后面只能跟数字 或 点
                    if (i == n || (i < n && ! Character.isDigit(chars[i]) && chars[i] != '.')){
                        return false;
                    }
                    // "+.8" 可以
                    if (i < n && chars[i] == '.'){
                        ++i;
                        // "+." 不行
                        if (i == n){
                            return false;
                        }
                    }
                    // 以点开头
                }else if (chars[i] == '.'){
                    ++i;
                    --dot;
                    // "." 不行
                    if (i == n || (i < n && ! Character.isDigit(chars[i])) ){
                        return false;
                    }
                }else{
                    ++i;
                }
                // 跳过数字
                while(i < n && Character.isDigit(chars[i]) ){
                    ++i;
                }
                if (i < n && chars[i] == '.'){
                    // 出现多个点 不行
                    if (dot == 0){
                        return false;
                    }
                    --dot;
                    ++i;
                    // 不以点开头的 点 后面可接 e 如  "46.e3"
                    if (i < n && !Character.isDigit(chars[i]) && chars[i] != 'e'){
                        return false;
                    }
                }
                // 跳过数字
                while(i < n && Character.isDigit(chars[i]) ){
                    ++i;
                }
                // 如果是 e
                if (i < n && chars[i] == 'e'){
                    ++i;
                    //以-， +， 开头
                    if (i < n && (chars[i] == '+' || chars[i] == '-')){
                        ++i;
                    }
                    // "6e+" 不行
                    if (i == n){
                        return false;
                    }
                    while(i < n && Character.isDigit(chars[i])){
                        ++i;
                    }
                    // "6e+755c" 不行
                    if (i < n){
                        return false;
                    }
                    // 不是 e  且 后面还有 其他不为数字的字符 不行
                }else if (i < n){
                    return false;
                }
                //不以 以上四种情况开头不行
            }else{
                return false;
            }
        }
        return true;
    }
}
