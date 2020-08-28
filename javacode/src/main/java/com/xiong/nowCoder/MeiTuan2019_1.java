package com.xiong.nowCoder;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/7 22:43
 * @description：
 * @modified By：
 * @version: $
 */
public class MeiTuan2019_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] strs = sc.nextLine().split(" ");

        System.out.println(check(strs));
    }

    private static String check(String[] strs) {

        int n = strs.length;
        ArrayDeque<String> stack = new ArrayDeque<>();

        // 偶数个元素肯定不符合要求
        if (n % 2 == 0) {
            return "error";
        }

        for (int i = 0; i < n; i++) {

            String str = strs[i];

            if (i % 2 == 0 && ("or".equals(str) || "and".equals(str))) {
                return "error";
            }

            if (i % 2 == 1 && ("false".equals(str) || "true".equals(str))) {
                return "error";
            }

            if ("and".equals(str)) {
                if (stack.isEmpty()) {
                    return "error";
                }
                if (i == n - 1) {
                    return "error";
                }

                String temp = stack.pop();
                String temp2 = strs[i + 1];
                if (temp.equals("false") || temp2.equals("false")) {
                    temp = "false";
                } else {
                    temp = "true";
                }
                stack.push(temp);
                i++;
            } else {
                stack.push(str);
            }
        }

        while (!stack.isEmpty()) {
            String temp = stack.pop();
            if ("true".equals(temp)) {
                return "true";
            }
        }

        return "false";

    }
}
