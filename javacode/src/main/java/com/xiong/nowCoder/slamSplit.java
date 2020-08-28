package com.xiong.nowCoder;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/8 15:14
 * @description：
 * @modified By：
 * @version: $
 */
public class slamSplit {

    // 史莱姆分裂
    private static int split(int slam, int target) {

        int i = 2;  // i 代表 切完后 史莱姆的个数， 那么 i- 1 代表 切的次数
        while (slam / i > 1) {
            double part = slam / (i + 0.0);

            int Cn2 = i * (i - 1) / 2;

            double sum = Cn2 * part * part;

            if (sum >= target) {
                return i - 1;
            }
            i++;
        }


        return -1;
    }

}
