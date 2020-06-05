package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/27 15:35
 * @description： 面试题11. 旋转数组的最小数字   二分法
 * @modified By：
 * @version: $
 */
public class J11_minArray {
    //二分
    public int minArray(int[] numbers) {

        int len = numbers.length;
        int left = 0;
        int right = len - 1; // 左闭右闭

        while (left < right){ // 相等时 结束
            int mid = left + (right - left) / 2;
            // 与区间右端点 比较
            if (numbers[mid] > numbers[right]){ //一定在 [mid+1, right]
                left = mid + 1;
            }else if (numbers[mid] < numbers[right]){//一定在 [left, mid]
                right = mid;
            }else { // 相等时 无法判断 在哪边  则缩小搜索范围
                right--;
            }
        }
        return numbers[left];
    }

}
