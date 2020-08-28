package com.xiong.LeetCode.BinarySearch;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/2/24 15:15
 * @description：
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，
 * 寻找有序数组里面比目标字母大的最小字母。
 *
 * 给定一个有序的字符数组 letters 和一个字符 target，
 * 要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符
 * @modified By：
 * @version: $
 */
public class B2_nextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {

        int low = 0;
        int high = letters.length -1;
        while (low <= high){
            int mid = low + (high -low) / 2;
            if (letters[mid] <= target){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        if (low < letters.length) {
            return letters[low];
        }else{
            return letters[0];
        }
    }

    public int minDays(int n) {
        if (n == 1){
            return 1;
        }
        if (n < 4){
            return 2;
        }


        int[] dp = new int[n  + 1];


        Arrays.fill(dp , Integer.MAX_VALUE);
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;

        for(int i = 4; i <= n ; i++){
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
            if ( i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i- i/2]  + 1);
            }
            if ( i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        return dp[n];


    }


}
