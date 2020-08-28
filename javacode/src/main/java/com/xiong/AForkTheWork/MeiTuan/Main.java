package com.xiong.AForkTheWork.MeiTuan;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/10 18:29
 * @description：
 * @modified By：
 * @version: $
 */
public class Main {

    public static void main(String[] args) {
    }

    public int maxDistance(int[] xs, int m) {
        Arrays.sort(xs);
        int l = 0;
        int r = inf;
        while(l < r){
            int k = (l + r + 1) / 2;
            if(check(xs, m, k)){
                l = k;
            }else{
                r = k - 1;
            }
        }
        return l;
    }

    int inf = (int)1e9;
    public boolean check(int[] xs, int m, int k){
        int last = -inf;
        for(int x : xs){
            if(x - last >= k){
                m--;
                last = x;
            }
        }
        return m <= 0;
    }
}
