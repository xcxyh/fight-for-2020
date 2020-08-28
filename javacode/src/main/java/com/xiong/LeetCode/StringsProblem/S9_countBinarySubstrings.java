package com.xiong.LeetCode.StringsProblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/23 18:10
 * @description： 696. 计数二进制子串  简单 但不会
 * <p>
 * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，
 * 并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 * @modified By：
 * @version: $
 */
public class S9_countBinarySubstrings {
    /**
     * @author: xiongcong
     * @Date: 2020/3/23 18:13
     * @Description: 输入: "00110011"
     * 输出: 6
     * 解释: 有6个子串具有相同数量的连续1和0：
     * “0011”，“01”，“1100”，“10”，“0011” 和 “01”。
     * 请注意，一些重复出现的子串要计算它们出现的次数。
     * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
     */

    public static void main(String[] args) {


        System.out.println(countBinarySubstrings("0111111"));
    }


    // 记录相同的 0  或 1 出现的次数，然后 list 中 相邻 次数 取最小值
    public static int countBinarySubstrings(String s) {

        List<Integer> list = new ArrayList<>();
        // 在尾部 添加一个 无效字符
        s = s + "#";
        char[] chars = s.toCharArray();
        int n = chars.length;

        int sum = 1;
        char curChar = chars[0];
        for(int i = 1; i < n; i++ ){
            if (chars[i] != curChar){
                list.add(sum);
                sum = 1;
                curChar = chars[i];
            }else{
                sum++;
            }
        }
        int ans = 0;
        for(int i = 1; i < list.size(); i++){
            ans += Math.min(list.get(i), list.get(i - 1));
        }

        return ans;
    }



    public static int countBinarySubstrings2(String s) {
        int count = 0;
        int curlen = 1;
        int prelen = 0;

        for (int i = 1; i <s.length(); i++) {

            if (s.charAt(i-1) == s.charAt(i)){ // 字符变化了 就记录下上一个的长度 然后把当前长度记为1
                curlen++;

            }else{
                prelen = curlen;
                curlen = 1;
            }

            if (prelen >= curlen){ //  前一个数字出现的次数 >= 后一个数字出现的次数，则一定包含满足条件的子串
                count++;
            }
        }
        return count;
    }

}
