package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/22 18:04
 * @description： KMP 字符串匹配算法
 * @modified By：
 * @version: $
 */
public class KMP_String {

    public static void main(String[] args) {
        System.out.println(kmpMatch("abcabaabaabcacb", "abcdabcg"));
    }


    // KMP 算法
    // ss: 原串(string)  pp: 匹配串(pattern)
    public int strStr(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }

        return -1;
    }




    //求模板字符串的 next 数组
    //对于模式串pattern ，next 数组的长度 比 pattern 的长度大1，
    // next[j]代表了pattern 的前j 个字符组成的子串中，其前缀和后缀的最长公共串的长度。
    //next[0] = -1
    private static int[] getNextArray(String pattern){

        int len = pattern.length();
        // next 数组长度 + 1
        int[] next = new int[len + 1];
        //参数初始化
        int k = -1;
        int j = 0;
        next[0] = -1;

        while (j < len ) {
            if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/3/22 18:18
     *  @Description: 若匹配成功，返回pattern在str中的位置（第一个相同字符对应的位置），若匹配失败，返回-1
     */
    public static int kmpMatch(String str,String pattern){
        int[] next = getNextArray(pattern);
        int i = 0;
        int j = 0;
        while (i < str.length() && j < pattern.length()){

            if (j == -1 || str.charAt(i) == pattern.charAt(j)){ //注意j == -1 的情况
                i++;
                j++;

            }else {
                j = next[j];
            }
        }

        if (j == pattern.length()){
            return i - j;
        }else {
            return -1;
        }
        //return j == pattern.length() ? i - j : -1;

    }
}
