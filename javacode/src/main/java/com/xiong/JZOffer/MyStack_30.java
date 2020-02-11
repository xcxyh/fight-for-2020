package com.xiong.JZOffer;

import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/9 15:35
 * @description： 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @modified By：
 * @version: $
 */
public class MyStack_30 {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else if(minStack.peek() > node){
            minStack.push(node);
        }else { //保证 data 和min 中的元素个数相同
            minStack.push(minStack.peek());
        }
        //以下用三元运算符表示
       // minStack.push(minStack.isEmpty()? node : Math.min(minStack.peek(),node));
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.pop();
    }

    public int min() {
        return minStack.pop();
    }
}
