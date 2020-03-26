package com.xiong.LeetCode.DailyProblems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/22 10:02
 * @description： 945. 使数组唯一的最小增量
 *
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 * @modified By：
 * @version: $
 */
public class D945_minIncrementForUnique {

    public static void main(String[] args) {
        System.out.println(new D945_minIncrementForUnique().minIncrementForUnique_2(new int[]{3,2,1,2,1,7}));
    }


    //超时了。。。。
    public int minIncrementForUnique(int[] A) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i <A.length ; i++) {
            while (set.contains(A[i])){
                A[i]++;
                count++;
            }
            set.add(A[i]);
        }
        return count;
    }

    public int minIncrementForUnique_2(int[] A) {
      int[] bucket = new int[40001];
    int max = -1;
        for (int num : A) {
            bucket[num]++;
            max = Math.max(max, num);
        }
        int count = 0;
        for (int i = 0; i <bucket.length - 1 ; i++) {
            if (bucket[i] > 1) {
                int d = bucket[i] - 1;
                count += d;
                bucket[i + 1] += d;
            }
        }
        // 最后, counter[max+1]里可能会有从counter[max]后移过来的，counter[max+1]里只留下1个，其它的d个后移。
        // 设 max+1 = x，那么后面的d个数就是[x+1,x+2,x+3,...,x+d],
        // 因此操作次数是[1,2,3,...,d],用求和公式求和。
        int d = bucket[max + 1] - 1;
        count += (1 + d) * d / 2;

        return  count;
    }
}
