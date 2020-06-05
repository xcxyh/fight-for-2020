package com.xiong.LeetCode.JianZhiOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/2 9:27
 * @description： 面试题62. 圆圈中最后剩下的数字    约瑟环问题
 * @modified By：
 * @version: $
 */
public class J62_lastRemaining {

    public int lastRemaining(int n, int m) {

        return recursive(n, m);
    }
    // 还是 掌握递归写法把  数学法难理解
    private int recursive(int n, int m){
        if (n == 1){
            return 0;
        }
        int x = recursive(n - 1, m); // 上一轮 删掉的数字的位置 为 x

        return (m + x) % n;  // 上一轮的 结果 + m 模上 本轮的 总数
    }
    // 数学法  逆推
    private int math(int n, int m){
         int ans = 0;

         for(int i = 1; i <= n; i++){
             ans = (ans + m) % i;
         }
         return ans;
    }

}
