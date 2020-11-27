package com.xiong.LeetCode.ArrayProblems;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/11/6 10:25
 * @description： 1356. 根据数字二进制下 1 的数目排序
 * @modified By：
 * @version: $
 */
public class Leet1356_sortByBits {



    public int[] sortByBits(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr){
            map.put(x, count1(x));
        }
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
        }
        list.sort((a, b) -> map.get(a).equals(map.get(b)) ? a - b : map.get(a) - map.get(b));
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int count1(int num){
        int ans = 0;

        while (num > 0){
            num = num & (num - 1);
            ans++;
        }
        return ans;
    }

    // np
    public int[] sortByBits_bigbrother(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            //Integer.bitCount(arr[i])转化为二进制一的数量
            ans[i] = count1(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            ans[i] = ans[i] % 10000000;
        }
        return ans;
    }
}
