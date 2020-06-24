package com.xiong.LeetCode.JianZhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/15 13:33
 * @description： 面试题41. 数据流中的中位数  利用 list 的 add(index, element) 这个插入函数 完成的
 * @modified By：
 * @version: $
 */
public class J41_MedianFinder {
    List<Integer> arr;
    /** initialize your data structure here. */
    public J41_MedianFinder() {
        arr = new ArrayList<>();
    }

    public void addNum(int num) {
        //二分找到插入位置
        int index = bysearch(arr, num);
        //插入
        arr.add(index, num);
    }

    public double findMedian() {
        int size = arr.size();
        if (size == 0){
            return 0.0;
        }

        if ((size & 1) == 0 ){
            int mid = size / 2 - 1;
            return (arr.get(mid) + arr.get(mid + 1)) / 2.0;
        }else{
            int mid = size / 2;
            return arr.get(mid);
        }
    }

    private int bysearch(List<Integer> arr,int target){
        int left = 0;
        int right = arr.size();

        while(left < right){
            int mid = left + (right - left) / 2;
            int cur = arr.get(mid);

            if (cur == target){
                right = mid;
            }else if (cur > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}
