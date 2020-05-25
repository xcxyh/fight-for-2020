package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/13 11:00
 * @description： 面试题43. 1～n整数中1出现的次数  ，这题就背答案吧 ，没说的
 * @modified By：
 * @version: $
 */
public class J43_countDigitOne {

    public int countDigitOne(int n) {

        int low = 0; // 低位部分
        int cur = n % 10; // 当前位上的数
        int high = n / 10; //高位部分
        int digit = 1; // 当前 位因子  1 10 100 ...

        int ans = 0;
        while (high != 0 || cur != 0) { //当 high 和 cur 同时为 0 时，说明已经越过最高位
            //根据当前位 有  三种情况
            if (cur == 0) {
                ans += high * digit;
            } else if (cur == 1) {
                ans += high * digit + low + 1;
            } else {
                ans += (high + 1) * digit;
            }

            // 下一轮 由 低到高 依次更新  low -> cur -> high , digit
            low = low + cur * digit;
            cur = high % 10;
            high = high / 10;
            digit = digit * 10;

        }
        return ans;
    }
}
