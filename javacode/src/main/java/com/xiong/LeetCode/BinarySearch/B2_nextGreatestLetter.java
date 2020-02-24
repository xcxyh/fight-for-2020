package com.xiong.LeetCode.BinarySearch;

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


}
