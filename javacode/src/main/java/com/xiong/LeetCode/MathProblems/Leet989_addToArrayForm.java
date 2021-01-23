package com.xiong.LeetCode.MathProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/22 11:08
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet989_addToArrayForm {


    // 按照 K 来
    public List<Integer> addToArrayForm(int[] A, int K) {
        int i = A.length - 1;

        LinkedList<Integer> list = new LinkedList<>();

        while (i >= 0 || K > 0) {

            if (i >= 0) {
                K += A[i--];
            }

            list.addFirst(K % 10);
            K = K / 10;
        }

        return list;
    }

    // 按位相加
    public List<Integer> addToArrayForm2(int[] A, int K) {
        int carry = 0;
        LinkedList<Integer> list = new LinkedList<>();
        int n = A.length;

        int[] arrK = getArr(K);

        int m = arrK.length;

        int i = n - 1, j = m - 1;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? A[i--] : 0;
            int b = j >= 0 ? arrK[j--] : 0;

            int sum = a + b + carry;

            carry = sum / 10;

            sum = sum % 10;

            list.addFirst(sum);
        }

        if (carry == 1) {
            list.addFirst(carry);
        }

        return list;
    }

    private int[] getArr(int K) {

        int n = String.valueOf(K).length();

        int[] arr = new int[n];
        int i = n - 1;
        while (K > 0) {

            arr[i--] = K % 10;
            K /= 10;
        }
        return arr;
    }
}
