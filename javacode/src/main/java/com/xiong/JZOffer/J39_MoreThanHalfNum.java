package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/6 19:55
 * @description： 数组中出现次数超过一半的数字
 * @modified By：
 * @version: $
 */
public class J39_MoreThanHalfNum {

    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[]{1,2,2,4,5,6,7,2}));
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        int len = array.length;
        //moore 法 找到 序列中的多数元素  (摩尔投票算法)
        int m = array[0];
        int count = 0;
        for (int num : array) {
            if (count == 0) {
                m = num;
                count++;
            }
            if (num == m) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        //然后判断 m 的次数是否超过一半
        for (int num : array) {
            if (num == m) {
                count++;
            }
        }
        return count > len / 2 ? m : 0;
    }
}
