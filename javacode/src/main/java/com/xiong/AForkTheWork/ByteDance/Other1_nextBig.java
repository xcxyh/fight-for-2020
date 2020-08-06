package com.xiong.AForkTheWork.ByteDance;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/12 10:42
 * @description：  给定一个正整数，找到由相同数字组成的下一个更大的数字
 * @modified By：
 * @version: $
 */
public class Other1_nextBig {
    //从末尾开始，尽量从低位开始将大的换到前面。比如 127374, 4 和 3 交换比 7 和 3 交换要好。
    public int nextNumber(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int length = chars.length;
        outerLoop: for(int i=length-1;i>0;i--) {
            for(int j=i-1;j>=0;j--) {
                if(chars[i] > chars[j]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                    break outerLoop;
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
