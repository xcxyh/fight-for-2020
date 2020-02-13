package com.xiong.JZOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/13 16:30
 * @description： 输入一个递增排序的数组和一个数字 S，
 * 在数组中查找两个数，使得他们的和正好是 S。
 * 如果有多对数字的和等于 S，输出两个数的乘积最小的。
 * @modified By：
 * @version: $
 */
public class J57_TwoNumSum {

    public static void main(String[] args) {

    }
    /**
     *  @author: xiongcong
     *  @Date: 2020/2/13 16:32
     *  @Description:  数组有序 且为递增排序 .由于两个数字的相差绝对值越大，他们的乘积越小
     *  双指针法  一个从头部 一个从尾部 开始
     * 如果两个指针指向元素的和 sum == target，那么得到要求的结果；
     * 如果 sum > target，移动较大的元素，使 sum 变小一些；
     * 如果 sum < target，移动较小的元素，使 sum 变大一些。
     */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = null;
        int head =0;
        int tail = array.length - 1;

        for (int i = 0; i <array.length ; i++) {
            int cur = array[head] + array[tail];
            if(cur < sum){ // 小于 则 head 指针 移动
                head++;
            }else if(cur > sum){// 大于 则 tail 指针 移动
                tail--;
            }else {
                result = new ArrayList<>(Arrays.asList(array[head],array[tail]));
                return result;
            }
        }
        return result;
    }


}
