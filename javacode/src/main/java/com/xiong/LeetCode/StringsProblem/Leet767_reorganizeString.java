package com.xiong.LeetCode.StringsProblem;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/11/30 17:24
 * @description： 767. 重构字符串
 * @modified By：
 * @version: $
 */
public class Leet767_reorganizeString {

    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        int maxCnt = 0;
        int n = S.length();
        int[] arr = new int[26];
        // 统计个数 和 某元素出现最多的次数
        for (char c : S.toCharArray()){
            int t = c - 'a';

            arr[t]++;
            if (maxCnt < arr[t]){
                maxCnt = arr[t];
            }
        }
        // 超过一半 则 一定重复
        if (maxCnt > (n + 1) / 2){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        // 最大堆  每次取前两个元素拼接，按出现次数排序 倒序
        Queue<Character> q = new PriorityQueue<>((c1, c2) -> arr[c2 - 'a']- arr[c1 - 'a']);

        // 添加所有元素进去
        for (int i = 0; i < 26; i++){
            char c = (char) (i + 'a');
            if (arr[i] > 0){
                q.offer(c);
            }
        }

        while (q.size() > 1){

            char c1 = q.poll();
            char c2 = q.poll();
            arr[c1 - 'a']--;
            arr[c2 - 'a']--;
            sb.append(c1).append(c2);
            if (arr[c1 - 'a'] > 0){
                q.offer(c1);
            }
            if (arr[c2 - 'a'] > 0){
                q.offer(c2);
            }
        }
        if (q.size() > 0){
            sb.append(q.poll());
        }
        return sb.toString();
    }


}
