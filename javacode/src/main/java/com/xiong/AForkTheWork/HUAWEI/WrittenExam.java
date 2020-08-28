package com.xiong.AForkTheWork.HUAWEI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/27 12:39
 * @description：  0826 华为笔试 只做了前两题
 * @modified By：
 * @version: $
 */
public class WrittenExam {

    public static void main(String[] args) {
        second();
    }

    // 第一题 位操作模拟
    public static void first() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            sb.append(change(i + 1));
        }
        // 完成第二步： 移位
        char c1 = sb.charAt(sb.length() - 2);
        char c2 = sb.charAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 2);
        StringBuilder newsb = new StringBuilder();
        newsb.append(c1).append(c2).append(sb);

        // 转回 十进制 打印
        StringBuilder ans = new StringBuilder();
        int n = newsb.length();
        for (int i = 0; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            int c = 32;
            while (i < n && c-- > 0) {
                temp.append(newsb.charAt(i++));
            }
            i--;
            // 二进制转 long
            long x = Long.parseLong(temp.toString(), 2);
            ans.append(x).append(" ");
        }

        System.out.println(ans.toString().substring(0, ans.length() - 1));
    }

    private static String change(int num) {
        String str = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder();
        int count = 32 - str.length();
        // 高位 补 0
        while (count-- > 0) {
            sb.append(0);
        }
        sb.append(str);
        char[] chars = sb.toString().toCharArray();
        // 第一步： 交换
        for (int i = sb.length() - 1; i >= 1; i = i - 2) {
            swap(chars, i, i - 1);
        }
        return new String(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    //第二题  矩形最大面积
    public static void second() {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String[] strs = str.substring(1, str.length() - 1).split("],");

        String[] str_x = strs[0].split(",");

        String[] str_y = strs[1].substring(1).split(",");

        int n = str_x.length;

        if (n != str_y.length){
            System.out.println(0);
            return;
        }

        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();

        int i = 0;
        while(i < n){
            // 无法转成数字时 跳出
            try {
                int x = Integer.valueOf(str_x[i]);
                int y = Integer.valueOf(str_y[i]);
                xList.add(x);
                yList.add(y);
                i++;
            } catch (Exception e) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(solve(xList, yList));
    }

    //[1,1,1,1,2,1,1],[5,2,5,4,5,1,6]
    private static int solve(List<Integer> xList, List<Integer> yList) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < xList.size(); i++) {
            int count = xList.get(i);
            int hight = yList.get(i);
            // 不能为负
            if (count < 0 || hight < 0){
                return 0;
            }

            while (count-- > 0) {
                list.add(hight);
            }
        }

        int[] heights = new int[list.size()];
        int i = 0;
        for (int x : list) {
            heights[i++] = x;
        }
        return largestRectangleArea(heights);
    }

    private static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0){
            return 0;
        }
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;

            while (left >= 0 && heights[left] >= heights[i]) {
                left--;
            }
            while (right < heights.length && heights[right] >= heights[i]) {
                right++;
            }
            int sum = heights[i] * (right - left - 1);

            max = Math.max(max, sum);

        }
        return max;
    }

}
