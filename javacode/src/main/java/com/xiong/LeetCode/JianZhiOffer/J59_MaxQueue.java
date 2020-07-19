package com.xiong.LeetCode.JianZhiOffer;

import java.util.LinkedList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/17 16:05
 * @description：  剑指 Offer 59 - II. 队列的最大值
 * @modified By：
 * @version: $
 */
public class J59_MaxQueue {
    private LinkedList<Integer> queue;
    private LinkedList<Integer> maxList; // 链表 用于存储当前最大值， 一个元素大小 依次 递减的 链表
    public J59_MaxQueue() {
        queue = new LinkedList<>();
        maxList = new LinkedList<>();
    }

    public int max_value() {
        return maxList.isEmpty() ? -1 : maxList.getFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        // 出队 max 中 所有 比当前 value 小的值
        while (!maxList.isEmpty() && maxList.getLast() < value){
            maxList.removeLast();
        }
        maxList.addLast(value);
    }

    public int pop_front() {
        // 先判断出队的是不是 当前最大值 ，若是 则 从链表中删除
        if (!queue.isEmpty() &&queue.peek().equals(maxList.getFirst())){
            maxList.removeFirst();
        }
        // 当前队首出队
        return queue.isEmpty() ? -1 : queue.poll();
    }
}
