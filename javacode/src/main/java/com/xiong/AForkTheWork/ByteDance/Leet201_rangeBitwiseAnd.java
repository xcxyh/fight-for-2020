package com.xiong.AForkTheWork.ByteDance;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/8 19:46
 * @description：  201. 数字范围按位与  一面
 * @modified By：
 * @version: $
 */
public class Leet201_rangeBitwiseAnd {

    //给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，
    // 返回此范围内所有数字的按位与（包含 m, n 两端点）。

    public int rangeBitwiseAnd(int m, int n) {

        // 1001 010
        // 1001 110
        // --->ret = 1001 000
        // 从 n  一直 去掉 n 的 最低位的 那个1  直到， n < m 就 找到了 那个结果
        while(n > m){
            n = n & ( n - 1);
        }
        return n;
    }

}
