package com.xiong.nowCoder;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/8 22:21
 * @description：  S1第10场 - 青铜&白银
 * @modified By：
 * @version: $
 */
public class nowCoder_1 {

    // 石头 剪刀 布 1
    public int Mostvictories (int n, int p1, int q1, int m1, int p2, int q2, int m2) {
        // write code here
        int ans = 0;
        ans += min(m1, p2);
        ans += min(p1, q2);
        ans += min(q1, m2);
        return ans;
    }


    /**
     * 牛牛排队
     * 返回牛牛最终是从第几个门进入食堂吃饭的
     * @param n int整型 代表门的数量
     * @param a int整型一维数组 代表每个门外等待的人数
     * @return int整型
     */
    public int solve (int n, int[] a) {
        // write code here
        int sum = 0;
        int i  = 0;
        int min = a[0];
        for(int x : a){
            if (x < min){
                min = x;
            }
        }

        int temp = min / n;
        for(int j = 0; j < n; j++){
            a[j] -= temp*n;
        }
        while(true){
            i = i % n;
            if (a[i] > sum){
                sum++;
            }else{
                return i + 1;
            }
            i++;
        }


    }
    // 石头 剪刀 布 2
    public int Highestscore (int n, int p1, int q1, int m1, int p2, int q2, int m2) {
        // write code here
        int ans = 0;
        // 胜的  牛哥必赢
        int t1 = min(m1, p2);
        int t2 = min(p1, q2);
        int t3 = min(q1, m2);
        ans += (t1 + t2 + t3);

        m1 -= t1;
        p2 -= t1;
        p1 -= t2;
        q2 -= t2;
        q1 -= t3;
        m2 -= t3;
        // 平的
        int z1 = min(p1,p2);
        int z2 = min(q1,q2);
        int z3 = min(m1,m2);

        p1 -= z1;
        p2 -= z1;
        q1 -= z2;
        q2 -= z2;
        m1 -= z3;
        m2 -= z3;
        // 输的，  与上面相反 ，也就是求 牛妹必赢，  即  牛哥必输
        ans -= min(p1, m2);
        ans -= min(q1, p2);
        ans -= min(m1, q2);
        return ans;
    }

    private int min(int x , int y){
        return Math.min(x, y);
    }
}
