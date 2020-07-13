package com.xiong.LeetCode.JianZhiOffer;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/27 17:56
 * @description： 剑指 Offer 31. 栈的压入、弹出序列
 * @modified By：
 * @version: $
 */
public class J31_validateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {

        if (pushed == null || pushed.length == 0){
            return true;
        }
        // 用一个栈模拟
        // 遇到 poped 中的元素就 pop
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while(j < popped.length){
            // 当栈顶元素 与 popped 中的元素相同时 ，pop
            while (j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
            // 当 pushed 中还有元素时 ，就 push
            if (i < pushed.length){
                stack.push(pushed[i++]);
            }else{ //否则 直接 break
                break;
            }

        }
        return stack.isEmpty();
    }


    public static boolean isPopOrder(int[] pushSeq , int[] popSeq){

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i <pushSeq.length ; i++) {
            stack.push(pushSeq[i]);
            //判断栈顶元素等于出栈序列中的元素时 stack 出栈
            while(j < pushSeq.length && !stack.isEmpty() && stack.peek() == popSeq[j] ){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();

    }
}
