package com.xiong.LeetCode.DFSandBFS;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/3 17:25
 * @description： 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class S1_MyQueue {
    //使用两个栈 来维护 进出队列
    Stack<Integer> in;
    Stack<Integer> out;


    public S1_MyQueue(){
        in = new Stack<>();
        out =new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        in2out();
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        in2out();
        return out.peek();

    }

    private void in2out(){
        //出队时当out 为空时 in 全部移到 out
        if (out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }



}
