package com.xiong.LeetCode.ArrayProblems.TreeArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/12 17:08
 * @description： 406. 根据身高重建队列
 * @modified By：
 * @version: $
 */
public class Leet406_reconstructQueue {

    public int[][] reconstructQueue(int[][] people) {


        // 按左端点 逆序，  若左端点相等，再按右端点升序
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));

        ArrayList<int[]> list = new ArrayList<>();

        // 再按照 右端点 插入 队列中
        for(int[] p : people){
            list.add(p[1], p);
        }


        int n = people.length;

        return list.toArray(new int[n][2]);

    }
}
