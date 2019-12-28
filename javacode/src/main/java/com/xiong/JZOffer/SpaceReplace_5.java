package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/6 20:38
 * @description： 将一个字符串中的空格替换成 "%20"。
 * Input:
 * "A B"
 * Output:
 * "A%20B"
 * <p>
 * 思路：1. 判断有多少个空格， 然后先在当前字符串末尾添加 2*n 个空格
 * 2. 双指针，p1 指向 原来末尾，p2 指向当前末尾，P1 和 P2 从后向前遍历，
 * 当 P1 遍历到一个空格时，就需要令 P2 指向的位置依次填充 02%（注意是逆序的），
 * 否则就填充上 P1 指向字符的值。
 * 3. 当 P2 遇到 P1 时（P2 <= P1），或者遍历结束（P1 < 0），退出。
 * @modified By：
 * @version: $
 */
public class SpaceReplace_5 {
    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("S B")));
    }

    public static String replaceSpace(StringBuffer str) {
        int p1 = str.length() - 1;
        //步骤1
        for (int i = 0; i <= p1 ; i++) { //这里条件 不能写成 i<str.length() 不然死循环
            if (str.charAt(i) == ' ') {
                str.append("  ");//two space
            }
        }

        int p2 = str.length()-1;

        while(p1>= 0 && p2 > p1){
            if(str.charAt(p1) == ' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }else{
                str.setCharAt(p2--,str.charAt(p1));
            }
            p1--;
        }
        return str.toString();

    }
}
