package com.xiong.LeetCode.DFSandBFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/3 17:48
 * @description：
 * @modified By：
 * @version: $
 */
public class S2_MyStack {

    Queue<Integer> queue;

    /** Initialize your data structure here. */
    public S2_MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        //入队时 要将所有元素都排在x后面
        int count = queue.size();
        while (count-- > 1){
            queue.add(queue.poll());
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
