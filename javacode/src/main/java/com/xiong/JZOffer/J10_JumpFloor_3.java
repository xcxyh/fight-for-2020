package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/14 14:05
 * @description： 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *  跳台阶问题
 *
 * @modified By：
 * @version: $
 */
public class J10_JumpFloor_3 {

    public static void main(String[] args) {
        System.out.println();
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/12/14 13:59
     *  @Description: 递归 ： 有重复计算子问题的问题
     */
    public static int jumpFloor(int target) {
        if( 0 < target && target <= 2){
            return target;
        }
        return jumpFloor(target-1) + jumpFloor(target-2);
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/12/14 13:47
     *  @Description:  由于该问题 只需要前两个值，所以不用将所有的结果缓存，只需缓存前两个即可。
     */
    private static int jumpFloor_dp2(int n) {
        return J10_RectCover_2.rectCover_dp2(n);
    }
}
