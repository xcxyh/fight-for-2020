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

        if (n <= 2){
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        //init
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n ; i++) {
            if (isPrime[i]){
                // 如果 i 是质数 那么 i 的 倍数都不是质数了
                //优化： 让 j 从 i 的平方开始遍历，而不是从 2 * i 开始, 避免重复计算
                for(int j = i * i; j < n; j += i){
                    isPrime[j] = false;
                }
            }

        }
        int count = 0;
        // 统计一下 质数的个数
        for (int i = 2; i < n ; i++) {
            if (isPrime[i]){
                count++;
                //System.out.print(i + " ");
            }
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
