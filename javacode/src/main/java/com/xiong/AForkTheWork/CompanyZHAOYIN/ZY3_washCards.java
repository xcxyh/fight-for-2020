package com.xiong.AForkTheWork.CompanyZHAOYIN;

import java.util.Scanner;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/22 20:06
 * @description： 洗牌
 * @modified By：
 * @version: $
 */
public class ZY3_washCards {

    /**
     * 输入依次  数组长度n  洗牌次数 k  数组元素
     * 输入 ： 7 2 1 2 3 4 5 6 7
     * <p>
     * 输出： 1 6 2 4 5 7 3
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] ans = washCards(n, k, arr);

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    /**
     * @author: xiongcong
     * @param: n  数组长度
     * @param: k  洗牌次数
     * @param: arr  数组长度
     */
    private static int[] washCards(int n, int k, int[] arr) {

        int[] temp = new int[n];

        int leftLen = n % 2 == 0 ? n / 2 : (n / 2) + 1;

        for (int i = 1; i <= k; i++) {
            int left = leftLen - 1;
            int right = n - 1;
            int index = n - 1;
            if (i % 2 == 1) { // 第 奇数次洗牌 先从右手拿一张 然后左手
                while (left >= 0 && right >= leftLen) {
                    temp[index--] = arr[right--];
                    temp[index--] = arr[left--];
                }
                if (left == 0) {
                    temp[index] = arr[left];
                }

            } else {// 第 偶数次洗牌 先从左手拿一张 然后右手
                while (left >= 0 && right >= leftLen) {
                    temp[index--] = arr[left--];
                    temp[index--] = arr[right--];
                }
                if (left == 0) {
                    temp[index] = arr[left];
                }
            }

            //更新
            for (int j = 0; j < n; j++) {
                arr[j] = temp[j];
            }

        }
        return arr;
    }
}
