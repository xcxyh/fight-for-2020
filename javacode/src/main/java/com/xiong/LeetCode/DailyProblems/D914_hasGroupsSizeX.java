package com.xiong.LeetCode.DailyProblems;


/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/27 17:40
 * @description：  914. 卡牌分组
 * @modified By：
 * @version: $
 */
public class D914_hasGroupsSizeX {


    public boolean hasGroupsSizeX(int[] deck) {

        if (deck.length <=1){
            return false;
        }

        int[] bucket = new int[10001];
        //记录每个元素的个数
        for (int k: deck) {
            bucket[k]++;
        }
        //求这些次数的公因数
        int X = bucket[0];
        for (int i = 0; i <bucket.length ; i++) {
            int temp = bucket[i];
            if (temp != 0){
                X = gcd(temp,X);
            }
        }

       return X > 1;
    }
    //求公因数  辗转相除法
    private int gcd (int a, int b){
        return b == 0 ? a : gcd(b,a % b);
    }
}
