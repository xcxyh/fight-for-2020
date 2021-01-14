package com.xiong.LeetCode.DailyProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/5 10:22
 * @description：  830. 较大分组的位置
 * @modified By：
 * @version: $
 */
public class Leet830_largeGroupPositions {


    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();

        int n = s.length();

        char[] c = s.toCharArray();

        int i = 0;
        int j = 0;

        while (j <= n) {
            if (j >= n || c[i] != c[j]) {
                if (j - i > 2) {
                    ans.add(Arrays.asList(i, j - 1));
                }
                i = j;
            }
            j++;
        }

        return ans;
    }
}
