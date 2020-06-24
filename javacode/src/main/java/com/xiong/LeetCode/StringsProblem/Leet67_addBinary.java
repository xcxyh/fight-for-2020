package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/23 11:56
 * @description：  67. 二进制求和
 * @modified By：
 * @version: $
 */
public class Leet67_addBinary {

    public String addBinary(String a, String b) {
        int carry = 0;

        int index1 = a.length() - 1;
        int index2 = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        while(index1 >=0 || index2 >= 0){

            int chra = index1 >=0 ? a.charAt(index1--) - '0' : 0;
            int chrb = index2 >=0 ? b.charAt(index2--) - '0' : 0;

            int ret = chra + chrb + carry;

            carry = ret / 2;

            ret = ret % 2;

            sb.append(ret);

        }

        if (carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();


    }
}
