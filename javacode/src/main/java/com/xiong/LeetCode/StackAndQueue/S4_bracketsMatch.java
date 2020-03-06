package com.xiong.LeetCode.StackAndQueue;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/4 21:07
 * @description：
 * 经典括号匹配问题
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class S4_bracketsMatch {

    public boolean isValid(String s) {
        //TODO
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
                char temp = s.charAt(i);
                switch (temp){
                    case '{':
                        stack.push(temp);
                        break;
                    case '[':
                        stack.push(temp);
                        break;
                    case '(':
                        stack.push(temp);
                        break;
                    case '}':
                        if (!stack.isEmpty() && stack.peek() == '{'){
                            stack.pop();
                            break;
                        }
                        return false;
                    case ']':
                        if (!stack.isEmpty() && stack.peek() == '['){
                            stack.pop();
                            break;
                        }
                        return false;
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '('){
                            stack.pop();
                            break;
                        }
                        return false;
                }
        }

        return stack.isEmpty();

    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/3/5 11:21
     *  @Description: 官方解答
     */
    public boolean isValidL(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cStack = stack.pop();
                boolean b1 = c == ')' && cStack != '(';
                boolean b2 = c == ']' && cStack != '[';
                boolean b3 = c == '}' && cStack != '{';
                if (b1 || b2 || b3) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
