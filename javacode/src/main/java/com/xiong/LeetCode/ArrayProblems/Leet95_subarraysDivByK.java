package com.xiong.LeetCode.ArrayProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/27 8:45
 * @description： 974. 和可被 K 整除的子数组   前缀和  两种形式 ： 数组 ， HashMap
 * @modified By：
 * @version: $
 */
public class Leet95_subarraysDivByK {

    public static void main(String[] args) {
        System.out.println(-7 % 3);
    }
    // 时间 O(n) 空间 O(n)
    public int subarraysDivByK(int[] A, int K) {
        // 存储 前缀和中 模 k 相同的 次数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0; // s2 % k == s1 % k
        int ans = 0;
        for(int n : A){
            sum = sum + n;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            //例 ： -7 % 3 = -1  ===> ( -1 + 3 ) % 3 = 2
            int mod = (sum % K + K) % K;
            int same = map.getOrDefault(mod, 0);
            ans += same;
            map.put(mod, same + 1);
        }
        return ans;

    }


    //  时间 O(n^2) 空间 O(n)  会超时
    public int subarraysDivByK_arr(int[] A, int K) {
        //前缀和
        int len = A.length;
        int[] s = new int[len + 1];
        for(int i = 1; i <= len; i++){
            s[i] = s[i - 1] + A[i - 1];
        }

        int ans = 0;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++){
                int t = s[i] - s[j];
                if (t % K == 0){
                    ans++;
                }
            }
        }
        return ans;
    }
}
