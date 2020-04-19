package com.xiong.LeetCode.ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/16 10:45
 * @description：  56. 合并区间
 * @modified By：
 * @version: $
 */
public class Leet56_merge {
    public int[][] merge(int[][] intervals) {
        if (intervals == null ||intervals.length == 0 || intervals[0].length == 0){
            return intervals;
        }
        //按照左端点的大小进行排序
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int rows = intervals.length;

        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        int i = 0;
        int j = 1;
        while(i < j && j < rows){
            int[] a = ans.get(i);
            int[] b = intervals[j];
            if(a[1] >= b[0]){
                //合并  要比较右端点的大小
                ans.set(i,new int[]{a[0],Math.max(a[1],b[1])});
                j++;
                //i 不变
            }else{
                ans.set(i,a);
                ans.add(b);
                i++;
                j++;
            }
        }
        return ans.toArray(new int[0][]);
    }
}
