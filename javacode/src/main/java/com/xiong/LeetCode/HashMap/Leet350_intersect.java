package com.xiong.LeetCode.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/13 9:50
 * @description： 350. 两个数组的交集 II
 * @modified By：
 * @version: $
 */
public class Leet350_intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        //遍历 nums1  全部添加到 map中， 并记录下次数

        for(int x : nums1){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        //遍历 nums2 找出交集
        List<Integer> list = new ArrayList<>();

        for(int x : nums2){
            if (map.containsKey(x)){
                map.put(x, map.get(x) -1);
                list.add(x);
                if (map.get(x) == 0){
                    map.remove(x);
                }
            }
        }

        int[] ans = new int[list.size()];
        int i = 0;
        for(int x : list){
            ans[i++] = x;
        }

        return ans;
    }
}
