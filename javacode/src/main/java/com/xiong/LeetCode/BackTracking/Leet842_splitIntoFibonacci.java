package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/8 15:27
 * @description： 842. 将数组拆分成斐波那契序列    与 306 题 一致
 * @modified By：
 * @version: $
 */
public class Leet842_splitIntoFibonacci {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }


    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<>();
        boolean canSplit = dfs(S, S.length(), 0, 0, 0, list);
        if (canSplit) {
            return list;
        }else {
            return new ArrayList<>();
        }
    }

    // num: 字符串
    // len: 字符串长度
    // idx: 当前遍历下标
    // sum: 前两个数之和
    // pre: 前面那个数的值
    // list: 临时存储
    private boolean dfs(String num, int len, int idx, int sum, int pre, List<Integer> list) {
        if (idx == len){
            return list.size() > 2;
        }

        for (int i = idx; i < len; i++) {
            int cur = toLongNum(num, idx, i);
            // 剪枝
            if (cur < 0) {
                continue;
            }
            // 剪枝
            if (list.size() >= 2 && cur != sum) {
                continue;
            }

            if (pre + cur > Integer.MAX_VALUE){
                continue;
            }

            list.add(cur);
            if (dfs(num, len, i + 1, pre + cur, cur, list)){
                return true;
            }else{
                list.remove(list.size() - 1);
            }

        }

        return false;

    }


    private int toLongNum(String num, int l, int r){

        if (l < r && num.charAt(l) == '0'){
            return -1;
        }
        long ans = 0;
        while (l <= r) {
            ans = ans * 10 + num.charAt(l) - '0';
            if (ans > Integer.MAX_VALUE){
                return -1;
            }
            l++;
        }
        return (int)ans;

    }
}
