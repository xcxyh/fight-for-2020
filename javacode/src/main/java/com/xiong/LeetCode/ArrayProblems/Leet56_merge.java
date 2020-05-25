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
    // 第二次手打
    public int[][] merge_new(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0){
            return intervals;
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        ArrayList<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] cur = intervals[i];
            int[] pre = list.get(list.size() -1);
            if (cur[0] <= pre[1]){
                int end = Math.max(cur[1], pre[1]);
                list.set(list.size() -1, new int[]{pre[0], end});
            }else{
                list.add(cur);
            }

        }
        //list.toArray(new int[0][]); 等效以下代码
        int size = list.size();
        int[][] ans = new int[size][2];
        for(int i = 0; i < size; i++){
            int[] temp = list.get(i);
            ans[i]= temp;
        }

        return ans;
    }




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
