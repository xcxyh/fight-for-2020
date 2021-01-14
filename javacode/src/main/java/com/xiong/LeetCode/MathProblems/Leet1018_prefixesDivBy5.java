package com.xiong.LeetCode.MathProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/14 10:22
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1018_prefixesDivBy5 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> ans = new ArrayList<>();
        int left = 0;
        for (int x : A) {
            // 只保留余数即可
            left = ((left << 1) + x ) % 5;
            if (left == 0) {
                ans.add(true);
            }else {
                ans.add(false);
            }
        }
        return ans;
    }
}
