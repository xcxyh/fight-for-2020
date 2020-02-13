package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/1/21 15:21
 * @description：
 * @modified By：
 * @version: $
 */
public class J50_FirstNotRep {


    public static void main(String[] args) {
        System.out.println(new J50_FirstNotRep().FirstNotRepeatingChar("abacc"));
    }

    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256]; //256 个字符的 ascii 码作为 index
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                return i;
        return -1;
    }
}
