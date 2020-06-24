package com.xiong.AForkTheWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/21 13:38
 * @description： java 输入输出模板
 * @modified By：
 * @version: $
 */
public class InputOutPutTemplate {



    /**
     * 0、Scanner
     * 循环读取 一个数
     */
    private void inout0() {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int num = sc.nextInt();
            System.out.println(num);
        }
    }

    /**
     * 1、Scanner （测试结果：220ms）
     * nextLine() 读取⼀⾏
     * nextInt()
     * nextLong()
     * n组数据就加个循环 while(n-- > 0){...}
     * 　next()不会吸取字符前/后的空格/Tab键，只吸取字符，开始吸取字符（字符前后不算）直到遇到空格/Tab键/回车截止吸取；
     * 　nextLine()吸取字符前后的空格/Tab键，回车键截止。
     */
    private void input1() {

        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        int n = Integer.valueOf(s[0]);

        int amount = Integer.valueOf(s[1]);

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        //输出
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 2、使用BufferedReader （测试结果：96ms）
     * read()，读入⼀个字符，不是数字,它会读回车的，所以我还是建议⼀整行 ⼀整行读
     * readLine(),读入每行的文本数据(包括空格)
     */
    private void intput2() throws IOException {

        //读取字符
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strs = br.readLine().split(" ");

        int n = Integer.valueOf(strs[0]);

        int amount = Integer.valueOf(strs[1]);

        int[] nums = new int[n];

        String[] numstrs = br.readLine().split(" ");

        for (int i = 0; i < n ; i++) {
            nums[i] = Integer.valueOf(numstrs[i]);
        }

        //输出
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 3、StreamTokenizer （测试结果：45ms）
     * 获取输⼊流并将其分析为Token（标记）,我们只要⽤nextToken()就能获
     取⼀个token了
     * 如果token是字符串 使⽤ st.sval就能获得
     * 如果token是数字，使⽤st.nval获得，默认是double，你如果是int需要
     强转⼀下
     *
     * 缺点：⽤该类读取数据时只能读取字⺟、数字、除c和c++注释符号以外的其
     他符号。
     * 如果含有特殊符号，也会占据⼀个令牌，并且返回null或者0
     */
    public void intput3(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new
                BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int amount = (int) st.nval;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {

            st.nextToken();
            nums[i] = (int) st.nval;
        }
        st.nextToken();
        System.out.println(coinChange(nums, amount));
    }
    // 322. 零钱兑换
    public int coinChange(int[] coins, int amount) {
        //dp
        //dp[i] 凑成 i 的最小硬币数

        //dp[i]
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // base case !
        for(int i = 0; i <= amount; i++){
            for(int coin : coins){

                if (i < coin){
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] ==  amount + 1 ? -1 : dp[amount];
    }

}
