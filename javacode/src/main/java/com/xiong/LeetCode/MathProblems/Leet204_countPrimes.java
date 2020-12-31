package com.xiong.LeetCode.MathProblems;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/22 9:07
 * @description： 204. 计数质数
 * @modified By：
 * @version: $
 */
public class Leet204_countPrimes {


    // 效率高解法， 排除法，质数的倍数都不是质数  Sieve of Eratosthenes
    public int countPrimes(int n) {

        boolean[] isPrime = new boolean[n];

        for (int i = 2; i < n; i++){
            isPrime[i] = true;
        }
        // 这里  i * i < n
        for (int i = 2; i * i < n; i++){
            if (!isPrime[i]){
                continue;
            }
            // 质数的 整数倍 一定不是质数
            for (int j = i * i; j < n; j += i){
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (boolean b : isPrime){
            if (b) count++;
        }

        return count;
    }



    // 平民版解法 会超时， 计算 100 以内的 质数还行  1500000 则超时
    public int countPrimes_old(int n) {
        if (n <= 2){
            return 0;
        }

        int count = 0;
        for(int i= 2; i < n; i++){
            if (isPrime(i)){
                count++;
                //System.out.print(i + " ");
            }
        }
        return count;
    }
    //判断一个数是不是质数
    private boolean isPrime(int n){
        for(int j = 2; j <= Math.sqrt(n); j++){
            if (n % j == 0){
                return false;
            }
        }
        return true;
    }


}
