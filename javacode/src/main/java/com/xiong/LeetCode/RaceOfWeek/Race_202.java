package com.xiong.LeetCode.RaceOfWeek;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/16 12:10
 * @description：
 * @modified By：
 * @version: $
 */
public class Race_202 {

    public static void main(String[] args) {
        maxDistance(new int[]{1,2,3,4,7},3 );
    }

    // 1  存在连续三个奇数的数组  错了 5次 我吐了
    public boolean threeConsecutiveOdds(int[] arr) {

        if (arr == null || arr.length < 3){
            return false;
        }
        int left = 0;
        int right = 0;
        while(right < arr.length){
            if (arr[right] % 2 != 0){
                right++;
                if (right - left == 3){
                    return true;
                }
            }else
            {   right++;
                left = right;

            }
        }

        return false;
    }

    //2  使数组中所有元素相等的最小操作数  ac  这应该是 所有周赛里面最简单的 第二题
    public int minOperations(int n) {
        int ans = 0;

        for(int i = 0; i < n / 2; i ++){
            ans += (n - 2*i - 1);
        }
        return ans;
    }

    //3 两球之间的磁力  没搞定
    public static int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);

        // 最小磁力
        int left = 1;
        // 最大磁力
        int right = arr[arr.length - 1] - arr[0];

        while(left < right){
            int mid = left + (right - left) / 2 + 1; // 取中点右端点
            if (check(arr, m, mid)){
                left = mid;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }

    private static boolean check(int[] position, int m, int mid ){

        // 记录 任意两球磁力 大于等于 mid 的 个数 ，如果 大于等于 m， 证明 mid 偏小
        // 如果小于 m ，证明 mid 偏大
        m--;
        int last = 0;
        int pos = 1;
        while (pos < position.length && m > 0) {
            if (position[pos] - position[last] >= mid) {
                last = pos;
                pos++;
                m--;
            } else {
                pos++;
            }
        }
        return m == 0;
    }



    //4  吃掉 N 个橘子的最少天数  错了 2次 都是超时
    public int minDays(int n) {
        if (n == 1){
            return 1;
        }
        if (n < 4){
            return 2;
        }
        // 加上 set  防止重复搜索 ，不然超时
        Set<Integer> set= new HashSet<>();
        Queue<Integer> q =  new LinkedList<>();

        q.offer(n);
        set.add(n);
        int ans = 0;
        while(!q.isEmpty()){

            int size = q.size();
            while(size-- > 0 ){
                int temp = q.poll();

                if (temp <= 0){
                    return ans;
                }
                if (!set.contains(temp - 1)){
                    q.offer(temp - 1);
                    set.add(temp - 1);
                }

                if (temp % 2 == 0 && !set.contains(temp /2)){
                    q.offer(temp / 2);
                    set.add(temp / 2);
                }
                if (temp % 3 == 0 && !set.contains(temp /3)){
                    q.offer(temp / 3);
                    set.add(temp  / 3);
                }
            }
            ans++;
        }
        return ans;
    }
}
