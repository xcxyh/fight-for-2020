package com.xiong.LeetCode.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/5 11:23
 * @description：
 * 根据每日 气温 列表，请重新生成一个列表，
 * 对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 
 * temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @modified By：
 * @version: $
 */
public class S5_dailyTemperatures {

    public static void main(String[] args) {
        new S5_dailyTemperatures().dailyTemperaturesL(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    //第二次做
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0){
            return T;
        }
        int n = T.length;
        int[] ans = new int[n];
        // 建议用 ArrayDeque 替代 Stack
        // J1.6 的类 肯定比 J1.0 的类好啊
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = 0;

        while(i < n){
            // 这也是对 单调栈的 使用
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                int pre = stack.pop();
                ans[pre] = i - pre;
            }

            stack.push(i); // 下标入栈 便于计算天数
            i++;
        }

        return ans;
    }



    /**
     *  @author: xiongcong
     *  @Date: 2020/3/5 12:09
     *  @Description: 官方解法
     */
    public int[] dailyTemperaturesL(int[] T) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        int k = 0;
        for (int i = 0; i <T.length ; i++) {
            //当前元素大于 栈顶的索引所对应的元素时， 可计算出 当前元素索引和 栈顶的 差值
            //即为 栈顶索引所对应的元素的 结果
            while (!stack.isEmpty() && T[i] >  T[stack.peek()]){
                int preindex = stack.pop();
                result[preindex] =i - preindex;
            }
            //将索引入栈
            stack.push(i);
        }
        return result;

    }


}
