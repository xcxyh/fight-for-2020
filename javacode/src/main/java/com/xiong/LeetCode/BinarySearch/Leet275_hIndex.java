package com.xiong.LeetCode.BinarySearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/26 17:44
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet275_hIndex {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length < 1) {
            return 0;
        }

        int n = citations.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int midVal = citations[mid];

            if (n - mid < midVal) {
                r = mid - 1;
            } else if (n - mid > midVal) {
                l = mid + 1;
            } else {
                return midVal;
            }
        }
        return n - l;
    }
}
