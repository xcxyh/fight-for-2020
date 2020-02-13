package com.xiong.JZOffer;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/10 20:45
 * @description： 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @modified By：
 * @version: $
 */
public class J09_QueueByStack {
    //专门用来进队
    Stack<Integer> stack1 = new Stack<Integer>();
    //专门用来出队
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //入栈1
        stack1.push(node);
    }

    public int pop() throws Exception {
        //出队前判断 栈2 是否为空，如果不为空，直接返回栈2 栈顶元素，如果栈2 为空，先将栈1全部弹出压栈到 栈2 中，再返回栈顶元素
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        //如果 stack1 和 stack2 都为空
        if (stack2.isEmpty()) {
            throw new Exception("queue is empty");
        }
        return stack2.pop();
    }
}
