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
