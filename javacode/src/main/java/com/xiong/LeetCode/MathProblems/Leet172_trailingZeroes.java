package com.xiong.LeetCode.MathProblems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/23 16:09
 * @description：  172. 阶乘后的零
 * @modified By：
 * @version: $
 */
public class Leet172_trailingZeroes {


    public int trailingZeroes(int n) {
        // 找特殊因子 5
        // 数 1 到 n 所有的数中有多少个 因子 5 就行
        int ans = 0;
        while(n > 0){
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
