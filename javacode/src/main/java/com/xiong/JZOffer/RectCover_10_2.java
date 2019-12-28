package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/14 13:53
 * @description： 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *  可等价为跳台阶问题，
 * @modified By：
 * @version: $
 */
public class RectCover_10_2 {
    public static void main(String[] args) {
        System.out.println();
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/12/14 13:59
     *  @Description: 递归 ： 有重复计算子问题的问题
     */
    public static int rectCover(int target) {
        if( 0 < target && target <= 2){
            return target;
        }
        return rectCover(target-1) + rectCover(target-2);
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/12/14 13:47
     *  @Description:  由于该问题 只需要前两个值，所以不用将所有的结果缓存，只需缓存前两个即可。
     */
    public static int rectCover_dp2(int n){

        if(n <= 2){
            return n;
        }
        int pre2 = 1;
        int pre1 = 2;
        int rect = 0;
        for (int i = 3; i < n+1 ; i++) {
            rect = pre2 + pre1;
            pre2 = pre1;
            pre1 = rect;
        }
        return rect;
    }
}
