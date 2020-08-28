package com.xiong.LeetCode.ArrayProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/28 12:29
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1399_countLargestGroup {

    public int countLargestGroup(int n) {
        int[] bucket = new int[40];

        for(int i = 1; i <= n; i++){
            bucket[get(i)]++;
        }

        int max = 0;
        for(int x : bucket){
            if (max < x){
                max = x;
            }
        }
        int count  = 0;
        for(int x : bucket){
            if (x == max){
                count++;
            }
        }

        return count;
    }

    private int get(int a){
        int sum  = 0;
        while(a > 0){
            sum += a % 10;
            a /= 10;
        }
        return sum;
    }
}
