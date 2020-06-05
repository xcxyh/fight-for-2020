package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/1 17:11
 * @description： 面试题58 - I. 翻转单词顺序  双指针法
 * @modified By：
 * @version: $
 */
public class J58_reverseWords_1 {
    public static void main(String[] args) {
        //System.out.println(reverseWords("  hello world!  "));
    }
    //双指针法 解此题
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        //双指针法  从尾部开始
        s = s.trim(); // 先去掉首尾空格
        int j = s.length() - 1;
        int i = j;
        StringBuilder ans = new StringBuilder();

        while(i >= 0){
            // 读到一个完整单词
            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            //添加到结果中
            ans.append(s, i+1, j+1);
            ans.append(' ');
            //读掉所有空格
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            // j 移动到此处
            j = i;

        }

        return ans.length()== 0 ? ans.toString() : ans.substring(0, ans.length() - 1);
    }


    // 不要使用如下方法解此题，虽然也可以通过
    public String reverseWords_WA(String s) {
        String[] strs = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for(String str : strs){
            sb.append(reverse(str));
            sb.append(" ");
        }

        return reverse(sb.substring(0, sb.length() - 1));
    }

    private String reverse(String str){
        StringBuilder sb = new StringBuilder();

        for(int i = str.length() - 1; i >= 0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
