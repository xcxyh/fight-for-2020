package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/3 9:25
 * @description： 415. 字符串相加
 * @modified By：
 * @version: $
 */
public class Leet415_addStrings {

    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0){
            return num2;
        }
        if (num2 == null || num2.length() == 0){
            return num1;
        }

        int carry = 0;

        StringBuilder sb = new StringBuilder();
        //ArrayDeque<Integer> stack = new ArrayDeque<>();

        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 > len2 ? len1 : len2;

        for(int i = 0; i < len; i++){
            int n1 = i < len1 ? num1.charAt(len1 - 1 - i) - '0' : 0;
            int n2 = i < len2 ? num2.charAt(len2 - 1 - i) - '0' : 0;

            int temp = n1 + n2 + carry;
            carry = temp / 10;
            temp = temp % 10;

            //stack.push(temp);
            sb.append(temp);
        }

        if (carry == 1){
            // stack.push(1);
            sb.append(1);
        }

        // while(!stack.isEmpty()){
        //     sb.append(stack.pop());
        // }

        return sb.reverse().toString();
    }


}
