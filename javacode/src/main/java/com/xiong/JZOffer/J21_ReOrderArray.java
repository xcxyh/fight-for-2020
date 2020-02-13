package com.xiong.JZOffer;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/1 11:08
 * @description： 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * %2 ==0 为 偶数
 * @modified By：
 * @version: $
 */
public class J21_ReOrderArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reBorderArray_2(new int[]{1,8,8,7,2,2,7,1,5,9,8})));
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/1 11:35
     *  @Description: 原地更改：使用冒泡思想，每次都当前偶数上浮到当前最右边
     *  复制度 时间 O(N^2) ,空间 O(1)
     */
    public static int[] reBorderArray(int[] arr) {
        int N = arr.length;
        //
        for (int i = N - 1; i > 0; i--) {
            //当数为偶数 他下一位为奇数时,就交换位置 冒泡一个
            for (int j = 0; j < i; j++) {
                if (arr[j] % 2 == 0 && arr[j + 1] % 2 != 0) {
                    swap(arr, j, j + 1);
                }
            }
        }
    return arr;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/1 11:42
     *  @Description: 利用额外空间：复制度 时间 O(N) ,空间 O(N)
     */
    public static int[] reBorderArray_2(int[] arr) {
        int N = arr.length;
        int[] result = new int[N];
        int k = 0;
        for (int i = 0; i <N ; i++) {
            if(arr[i] % 2 != 0){
                result[k++]=arr[i];
            }
        }
        for (int i = 0; i <N ; i++) {
            if(arr[i] % 2 == 0){
                result[k++]=arr[i];
            }
        }
        return result;
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
