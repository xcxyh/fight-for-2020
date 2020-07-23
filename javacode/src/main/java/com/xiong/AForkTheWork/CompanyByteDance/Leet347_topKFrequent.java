package com.xiong.AForkTheWork.CompanyByteDance;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/22 16:30
 * @description： 347. 前 K 个高频元素
 * @modified By：
 * @version: $
 */
public class Leet347_topKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //小顶堆  按照 频率 排序
        Queue<Integer> q = new PriorityQueue<>((a, b) -> map.get(a)- map.get(b) );

        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        // 按照频率
        for(int key : map.keySet()){
            q.add(key);
            if (q.size() > k){
                q.poll();
            }
        }

        int size = q.size();
        int[] ans = new int[size];

        for(int i = 0; i < size && !q.isEmpty(); i++){ // 这里不要写  q.size()
            ans[i] = q.poll();
        }

        return ans;
    }
}
