package com.xiong.LeetCode.JianZhiOffer;

import java.util.PriorityQueue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/15 13:42
 * @description： 面试题41. 数据流中的中位数  利用 一个大顶堆 和一个小顶堆 实现的
 * @modified By：
 * @version: $
 */
public class J41_MedianFinder_PriorityQueue {

    private PriorityQueue<Integer> lowPart;  // 大顶堆
    private PriorityQueue<Integer> highPart; // 小顶堆
    int size = 0;
    /**
     * initialize your data structure here.
     */
    public J41_MedianFinder_PriorityQueue() {
        lowPart = new PriorityQueue<>((a, b) -> (b - a));
        highPart = new PriorityQueue<>();
    }
    //若总大小为奇数 则 lowPart 的 堆顶即为 答案
    public void addNum(int num) {

        if(lowPart.size() != highPart.size()) {
            lowPart.add(num);
            highPart.add(lowPart.poll());
        } else {
            highPart.add(num);
            lowPart.add(highPart.poll());
        }
        size++;
    }

    public double findMedian() {
        if ((size & 1) == 1){
            return (double)lowPart.peek();
        }else{
            return (double) (lowPart.peek() + highPart.peek()) / 2;
        }
    }
}
