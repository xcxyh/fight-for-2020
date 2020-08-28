package com.xiong.LeetCode.Calculator_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/11 18:29
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet224_calculate {


    public static void main(String[] args) {
        System.out.println(new Leet224_calculate().calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    //执行用时：7 ms, 在所有 Java 提交中击败了95.37%的用户
    //内存消耗：39.7 MB, 在所有 Java 提交中击败了89.21%的用户

    public int calculate(String s) {

        return calculateHelp(s);

    }
    // 全局变量
    private int i = 0;
    private int calculateHelp(String s){
        Deque<Integer> stack  = new ArrayDeque<>();
        int n  = s.length();
        char sign = '+';
        int num = 0;

        while(i < n) {
            char c = s.charAt(i);

            if (c == '(') {
                // 这里要 i++ 要越过这个 左括号
                i++;
                num = calculateHelp(s);
            }

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
                // 遇到右括号 弹出
                if (c == ')') {
                    break;
                }
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
