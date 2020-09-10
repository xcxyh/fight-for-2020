package com.xiong.LeetCode.DFSandBFS;

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
    private Stack<Integer> data;
    private Stack<Integer> min;
    /** initialize your data structure here. */
    public S3_minStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.isEmpty()){
            min.push(x);
        }else{
            min.push(Math.min(x, min.peek()));
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
