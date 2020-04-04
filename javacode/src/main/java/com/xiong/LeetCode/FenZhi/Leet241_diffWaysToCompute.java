package com.xiong.LeetCode.FenZhi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/1 17:51
 * @description： 241. 为运算表达式设计优先级  使用的是分治法
 * @modified By：
 * @version: $
 */
public class Leet241_diffWaysToCompute {

    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2-1-1"));
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') { // 运算符 左右 分治
                List<Integer> left = diffWaysToCompute(input.substring(0, i) );
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                //将 left 和 right 的结果 取 笛卡尔积
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+':
                                result.add(l + r);
                                break;
                            case '-':
                                result.add(l - r);
                                break;
                            case '*':
                                result.add(l * r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }

}
