package com.xiong.LeetCode.StackAndQueue;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/4 20:59
 * @description：
 * @modified By：
 * @version: $
 */
public class S3_minStack {

    //使用两个栈
    Stack<Integer> dataStack;
    Stack<Integer> minStack;
    Integer min;
    /** initialize your data structure here. */
    public S3_minStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        dataStack.push(x);
        min = Math.min(min,x);
        minStack.push(min);
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
        //弹栈时 要判断 是否为空 来更新 min
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
