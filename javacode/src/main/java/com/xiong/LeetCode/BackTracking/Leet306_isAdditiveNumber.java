package com.xiong.LeetCode.BackTracking;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/8 15:02
 * @description： 306. 累加数
 * @modified By：
 * @version: $
 */
public class Leet306_isAdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        return dfs(num, num.length(), 0, 0, 0, 0);
    }


    // num : 字符串
    // len : 字符串长度
    // idx: 当前遍历下标
    // sum: 前两个数之和
    // pre: 前面那个数的值
    // k: 记录当前数是累加序列中的 第几个数字
    private boolean dfs(String num, int len, int idx, long sum, long pre, int k) {
        if (idx == len){
            return k > 2;
        }

        for (int i = idx; i < len; i++) {
            long cur = toLongNum(num, idx, i);
            // 剪枝
            if (cur < 0) {
                continue;
            }
            // 剪枝
            if (k >= 2 && cur != sum) {
                continue;
            }

            if (dfs(num, len, i + 1, pre + cur, cur, k + 1)){
                return true;
            }

        }
        return false;

    }


    private long toLongNum(String num, int l, int r){

        if (l < r && num.charAt(l) == '0'){
            return -1;
        }

        long ans = 0;
        while (l <= r) {
            ans = ans * 10 + num.charAt(l) - '0';
            l++;
        }
        return ans;

    }
}
