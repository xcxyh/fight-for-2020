package com.xiong.LeetCode.JianZhiOffer;

import java.util.ArrayDeque;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/30 9:47
 * @description： 剑指 Offer 09. 用两个栈实现队列
 * @modified By：
 * @version: $
 */
public class J09_CQueue {

    private ArrayDeque<Integer> in;
    private ArrayDeque<Integer> out;
    public J09_CQueue() {
        in = new ArrayDeque<>();
        out = new ArrayDeque<>();

    }

    public void appendTail(int value) {
        in.push(value);
    }

    public int deleteHead() {
        if (out.isEmpty()){
            while(!in.isEmpty()){
                out.push(in.pop());
            }
        }

        return out.isEmpty() ? -1 : out.pop();
    }
}
