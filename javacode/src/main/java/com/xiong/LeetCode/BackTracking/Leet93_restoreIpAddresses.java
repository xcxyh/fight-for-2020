package com.xiong.LeetCode.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/9 10:02
 * @description： 93. 复原IP地址  回溯 或者  暴力遍历
 * @modified By：
 * @version: $
 */
public class Leet93_restoreIpAddresses {

    // 暴力遍历
    public List<String> restoreIpAddresses_baoli(String s) {

        List<String> ans = new ArrayList<>();

        int len = s.length();

        if (len < 4 || len > 12) {
            return ans;
        }

        for (int i = 0; i < len - 3; i++) {
            int a = changeStrToInt(s.substring(0, i + 1));
            for (int j = i + 1; j < len - 2; j++) {
                int b = changeStrToInt(s.substring(i + 1, j + 1));
                for (int k = j + 1; k < len - 1; k++) {
                    int c = changeStrToInt(s.substring(j + 1, k + 1));
                    int d = changeStrToInt(s.substring(k + 1));

                    if (a != -1 && b != -1 && c != -1 && d != -1) {
                        ans.add(a + "." + b + "." + c + "." + d);
                    }

                }
            }
        }
        return ans;
    }

    private int changeStrToInt(String s) {
        int n = s.length();
        if (n > 1 && s.charAt(0) == '0') {
            return -1;
        }
        int ret = 0;
        for (char c : s.toCharArray()) {
            int x = c - '0';
            ret = ret * 10 + x;
        }
        if (ret > 255) {
            return -1;
        }
        return ret;
    }


    // 回溯做法
    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        int n = s.length();
        if (n < 4 || n > 12) {
            return ans;
        }

        LinkedList<String> list = new LinkedList<>();

        backtracking(s, 0, 0, list);

        return ans;
    }

    private void backtracking(String s, int splitCount, int begin, LinkedList<String> list) {


        int len = s.length();
        // 到达尾部
        if (begin == len) {
            // 分了四段
            if (splitCount == 4) {
                ans.add(String.join(".", list));
                return;
            }

        }

        // 剪枝，没有这个也是正确的，但是多了不必要的回溯路径
        if (len - begin > 3 * (4 - splitCount) || len - begin < (4 - splitCount)) {
            return;
        }

        // 1位数 2位数 3 位数 最多三位数
        for (int i = 0; i < 3; i++) {
            if (begin + i >= len) {
                break;
            }

            int segment = changeStrToInt(s, begin, begin + i);
            // -1 代表 不合法， 不在 0 --- 255 之间 或者 以 0 开头了
            if (segment != -1) {
                list.add(segment + "");
                backtracking(s, splitCount + 1, begin + i + 1, list);
                list.removeLast();
            }
        }

    }

    private int changeStrToInt(String s, int begin, int end) {

        int len = end - begin + 1;

        if (len > 1 && s.charAt(begin) == '0') {
            return -1;
        }
        int segment = 0;
        for (int i = begin; i <= end; i++) {
            int c = s.charAt(i) - '0';
            segment = segment * 10 + c;
        }

        if (segment > 255) {
            return -1;
        }

        return segment;
    }
}
