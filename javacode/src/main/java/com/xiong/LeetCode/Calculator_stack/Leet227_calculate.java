package com.xiong.LeetCode.Calculator_stack;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/11 18:17
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet227_calculate {


    // 不包含括号的简单版本
    public int calculate(String s) {

        int i = 0;
        Deque<Integer> stack  = new ArrayDeque<>();
        int n  = s.length();
        char sign = '+';
        int num = 0;

        while(i < n) {
            char c = s.charAt(i);

            if (Character.isDigit(c)){
                num = num* 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == n - 1){
                switch(sign){

                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        // 这里暂时不判空
                        stack.push(num * stack.pop());
                        break;
                    case '/':
                        // 这里暂时不判空
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                sign = c;
                // 重置
                num = 0;
            }

            i++;
        }

        //将栈中的所有数加起来即可
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
