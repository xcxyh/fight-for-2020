package com.xiong.AForkTheWork.ZhaoYin;

import java.util.Scanner;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/21 13:01
 * @description：  答题环境测试题 ----- 整数的分解方法-腾讯 2017春招真题
 * 题目：
 * 如下示例：
 * 1：共0种分解方法；
 * 2：共0种分解方法；
 * 3：3=2+1 共1种分解方法；
 * 4：4=3+1=2+1+1 共2种分解方法；
 * 5：5=4+1=3+2=3+1+1=2+2+1=2+1+1+1 共5种分解方法
 * 6：6=5+1=4+2=4+1+1=3+2+1=3+1+1+1=2+2+1+1=2+1+1+1+1 共7种分解方法
 * 以此类推，求一任意整数num有几种分解方法？
 * @modified By：
 * @version: $
 */
public class Test {

    // 手写输入输出

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
            int num = sc.nextInt();

            System.out.println(numBreak(num));
        }

    }

    // 答案函数
    //为保证输出的唯一性，保持降序排列
    private static int numBreak(int num){
        if (num <= 2){
            return 0;
        }
        
        //dp
        
        //dp[i][j] 表示 数 i 分解后 以 j 结尾的 分解方法数
        
        int[][] dp = new int[num + 1][];
        
        // 从 3 开始
        for (int i = 3; i <= num ; i++) {
            // 例： 7 ： (7-1) /2 = 3  所以它的分解中 只能 以 1 2 3 结尾
            int maxj =  (int) Math.floor((i - 1) / 2d);

            dp[i] = new int[maxj];
            for (int j = 0; j < maxj ; j++) {
                dp[i][j] = 1;
                //分解成两个数
                int num2 = j + 1;// j从 0 开始  所以 要 + 1 ，num2 即为 那个结尾的数字
                int num1 = i - num2;
                //只在num1 > 2 * num2 时分解num1（否则无法保证降序，例：5=3+2，3继续分解出2+1，则5=2+1+2不是降序）
                if (num1 > num2 * 2){
                    if (num1 % 2 == 0){//num1是偶数，计算分解情况时+1
                        dp[i][j]++;
                    }

                    // 状态转移 ,, 其中 从 j 开始 分解结果的结尾不能小于 j
                    for (int k = j; k < dp[num1].length ; k++) {
                        dp[i][j] += dp[num1][k];
                    }
                }
            }
        }
        //统计答案
        int ans = 0;
        for (int i = 0; i < dp[num].length; i++) {
            ans += dp[num][i];
        }
        return ans;
        
    }

}
