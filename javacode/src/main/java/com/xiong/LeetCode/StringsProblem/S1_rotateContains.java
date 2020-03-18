package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/17 10:09
 * @description： 字符串包含
 * 给定两个字符串s1,s2，要求判断s2能否被s1循环移位得到的字符串包含。
 *
 * 例如给定s1="AABCD"和s2="CDAA“，返回true ；给定s1="ABCD"和s2="ACBD"，返回false。
 * @modified By：
 * @version: $
 */
public class S1_rotateContains {

    public boolean rotateContains(String s1,String s2){

        StringBuilder stringBuilder = new StringBuilder(s1);
        //两个 s1 字符串  拼起来  AABCDAABCD  中一定包含 CDAA
        stringBuilder.append(s1);
        //则 如果 s2 是 s1 的位移包含字串  那 s2 一定是  s1+s1 的 包含字串
        return stringBuilder.toString().contains(s2);

    }
}
