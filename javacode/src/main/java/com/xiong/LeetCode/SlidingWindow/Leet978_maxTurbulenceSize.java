package com.xiong.LeetCode.SlidingWindow;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/8 9:53
 * @description： 978. 最长湍流子数组
 * @modified By：
 * @version: $
 */
public class Leet978_maxTurbulenceSize {

    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        int n = arr.length;
        int left= 0, right = 0;
        // 0 为 相等  -1 为 小 1 为 大
        int flag = 0;
        int ans = 0;
        while (right < n - 1) {
            if (arr[right] < arr[right + 1]) {
                if (right > 0 && flag == -1) {
                    left = right;
                }
                flag = -1;
            }else if (arr[right] > arr[right + 1]) {
                if (right > 0 && flag == 1) {
                    left = right;
                }
                flag = 1;
            }else {
                left = right + 1;
                flag = 0;
            }
            right++;
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
