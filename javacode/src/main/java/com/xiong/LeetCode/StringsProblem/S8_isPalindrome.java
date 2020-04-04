package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/23 18:09
 * @description： 9. 回文数
 * @modified By：
 * @version: $
 */
public class S8_isPalindrome {

    public boolean isPalindrome(int x) {
        String s = x + "";
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    //数学方法
    public boolean isPalindrome_math(int x) {
        if (x < 0){
            return false;
        }
        int k = x;
        int n = 0;
        while(k > 0){
            n = k % 10 + n*10; // 从个位开始 个位 变 最高位 构建 数字
            k = k /10; // 十位 百位 。。。
        }
        // 例 ： 123 -> 321
        return x == n;
    }

}
