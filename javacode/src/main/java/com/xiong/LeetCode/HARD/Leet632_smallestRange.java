package com.xiong.LeetCode.HARD;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/1 10:28
 * @description： 632. 最小区间
 * @modified By：
 * @version: $
 */
public class Leet632_smallestRange {

    class NumGroup{
        public NumGroup(int num, int grp){
            this.num = num;
            this.grp = grp;
        }
        int num; //数值
        int grp; //组号
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        //因为每次都要找最小元素，所以维护一个最小堆比较合适
        PriorityQueue<NumGroup> numgrp = new PriorityQueue<>(new Comparator<NumGroup>(){
            @Override
            public int compare(NumGroup n1, NumGroup n2){
                return n1.num - n2.num;
            }
        });

        int end = -100001;  //int end = Integer.MIN_VALUE;
        //记录每个数组当前的指针位置，一开始都指向第0个元素，即每个区间的最小元素
        int[] index = new int[nums.size()];

        //起始区间
        for(int i = 0; i < nums.size(); i++){
            if(nums.get(i).get(0) > end) end = nums.get(i).get(0);
            NumGroup num = new NumGroup(nums.get(i).get(0), i);
            numgrp.offer(num);
        }

        int max = end;
        int start = numgrp.peek().num;
        int min = start;
        int len = end - start + 1;

        while(true){
            //grp为当前最小元素的原数组号
            int grp = numgrp.poll().grp;
            //如果当前最小元素已经是原数组最大元素了，则退出
            if(index[grp]+1 == nums.get(grp).size()) break;

            //索引++
            index[grp]++;
            NumGroup n = new NumGroup(nums.get(grp).get(index[grp]), grp);
            numgrp.offer(n);
            //当前最大值
            if(n.num > max) max = n.num;
            min = numgrp.peek().num;
            //长度变小
            if(max-min+1 < len){
                start = min;
                end = max;
                len = max-min+1;
            }
        }

        return new int[]{start, end};
    }
}
