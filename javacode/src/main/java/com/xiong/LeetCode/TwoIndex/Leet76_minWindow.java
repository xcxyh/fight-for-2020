package com.xiong.LeetCode.TwoIndex;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/5 20:49
 * @description： 76. 最小覆盖子串  双指针的高级用法：滑动窗口
 * @modified By：
 * @version: $
 */
public class Leet76_minWindow {
    public static void main(String[] args) {
        String s = "adlkfjldjgldasigjladgjlaidjgladjgalgjdo";
        String t = "jgldasijladlaid";
        System.out.println(new Leet76_minWindow().minWindow(s, t));
    }


    //第二次写
    public String minWindow(String s, String t) {
        //sliding window
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();

        //init 记录目标中各字符出现次数
        for(char c : t.toCharArray()){
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int minLen = Integer.MAX_VALUE;
        int len = s.length();
        int match = 0; //有多少 种 字符匹配了

        int ansleft = 0;
        int ansright = 0;
        while(right < len){
            char c = s.charAt(right);
            if (target.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() == target.get(c).intValue()){
                    match++;
                }
            }
            right++;
            //全匹配了
            while (match == target.size()){
                //更新结果
                if (right - left < minLen){
                    minLen = right - left;
                    ansleft = left;
                    ansright = right;
                }
                //滑窗左端点移动
                char cleft = s.charAt(left);
                if (target.containsKey(cleft)){
                    window.put(cleft, window.get(cleft) - 1);
                    if (window.get(cleft) < target.get(cleft)){
                        match--;
                    }
                }
                left++;
            }

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansleft, ansright);

    }

    public String minWindow_1(String s, String t) {
        //滑动窗口
        int left = 0;
        int right = 0;
        int len = s.length();
        int ansStrStart = 0;
        int ansStrEnd = 0;
        int minLen = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        // 初始化needs
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);

        }
        // 记录 window 中已经有多少字符符合要求了
        int match = 0;
        while (right < len) {
            char c1 = s.charAt(right);
            if (needs.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                // 当 值 不在 -128 - 127 内时 会新建 Integer对象  此时 == 比较的是对象的地址
                // 那肯定就不相等了 所以要加 Integer 对象的 .intValue() 方法 拆箱 成数字
                //  深坑 ！！！  不然最后一个样例无法通过
                if (window.get(c1).intValue() == needs.get(c1).intValue()) { // 这里 为 Integer 对象
                    match++;
                }
            }
            right++;

            while (match == needs.size()) { // 这里不是 等于 t.length() 因为 window 完全包含 needs 就行了
                //更新结果
                if (right - left < minLen) {
                    ansStrStart = left; // 结果的起点 便于后面的 substring 操作
                    ansStrEnd = right;
                    minLen = right - left;
                }

                char c2 = s.charAt(left); // 滑动窗口 最左边 字符
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1); // 这里一定可get到
                    if (window.get(c2) < needs.get(c2)) {
                        match--;
                    }
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansStrStart, ansStrEnd);
    }


}
