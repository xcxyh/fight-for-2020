package com.xiong.LeetCode.RaceOfWeek;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/29 9:58
 * @description： 第 182 场力扣周赛
 * @modified By：
 * @version: $
 */
public class Race_182 {

    public static void main(String[] args) {
        System.out.println(numTeams(new int[]{1, 2, 3, 4}));
    }

    //题1 通过
    public int findLucky(int[] arr) {
        int[] bucket = new int[501];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int max = -1;
        for (int i = 1; i < 501; i++) {
            if (i == bucket[i]) {
                max = Math.max(max, i);
            }
        }
        return max;
    }

    //题2  通过
    public static int numTeams(int[] rating) {
        int n = rating.length;
        if (n < 3) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (rating[i] < rating[j] && rating[j] < rating[k]
                            || rating[i] > rating[j] && rating[j] > rating[k]) {
                        ans += 1;
                    }
                }
            }
        }
        return ans;
    }

    //题3  当时不会
    private Map<Integer, String> enter = new HashMap<>(); //存 进站信息
    private Map<Integer, Integer> stamp = new HashMap<>(); //存 进站时间
    private Map<String, Integer> sumTime = new HashMap<>(); //存 站到站 的 总时间
    private Map<String, Integer> count = new HashMap<>();//存 站到站 的 总条数

    public void checkIn(int id, String stationName, int t) {
        //进站 再进站 就覆盖
        enter.put(id, stationName);
        stamp.put(id, t);
    }

    private String concat(String s1, String s2) {
        return s1 + "->" + s2;
    }

    public void checkOut(int id, String stationName, int t) {

        String startStation = enter.get(id);
        Integer startTime = stamp.get(id);
        String stos = concat(startStation, stationName);
        sumTime.put(stos, sumTime.getOrDefault(stos, 0) + t - startTime);
        count.put(stos, count.getOrDefault(stos, 0) + 1);
    }

    // 直接到达
    public double getAverageTime(String startStation, String endStation) {
        String stos = concat(startStation, endStation);
        return sumTime.get(stos) / (double) count.get(stos);
    }

    //题4   5371. 找到所有好字符串  没做  太难了  我太垃圾了


}
