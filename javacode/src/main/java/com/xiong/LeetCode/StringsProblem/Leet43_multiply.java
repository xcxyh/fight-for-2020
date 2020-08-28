package com.xiong.LeetCode.StringsProblem;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/10 16:25
 * @description： 43. 字符串相乘   模拟题
 * @modified By：
 * @version: $
 */
public class Leet43_multiply {

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0){
            return num2;
        }
        if (num2 == null || num2.length() == 0){
            return num1;
        }

        int n1 = num1.length();
        int n2 = num2.length();
        int[] arr = new int[n1 + n2];
        for(int i = n1 - 1; i >= 0; i--){
            for(int j = n2 -1; j >= 0; j--){
                int c1 = num1.charAt(i) - '0';
                int c2 = num2.charAt(j) - '0';
                // 这里要先 加 arr[i + j + 1]， 参与运算
                int sum = c1 * c2 + arr[i + j + 1];
                arr[i + j + 1] = sum % 10;

                arr[i + j] += sum / 10;

            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉 首位 0 ，如果有的话
        while(i < arr.length && arr[i] == 0){
            i++;
        }
        while(i < arr.length){
            sb.append(arr[i]);
            i++;
        }
        // 注意 0 的情况
        return sb.length()== 0 ? "0" : sb.toString();
    }
}
