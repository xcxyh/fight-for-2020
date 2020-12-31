package com.xiong.LeetCode.GreedyAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/12 12:39
 * @description： 649. Dota2 参议院  贪心的否决离他本身最近的 不同阵营的议员
 * @modified By：
 * @version: $
 */
public class Leet649_predictPartyVictory {

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        boolean R = true; // 一轮之后是否还有 R 议员
        boolean D = true; // 一轮之后是否还有 D 议员
        // flag > 0 表示 R 有否决权 当前 D 要被否决
        // flag < 0 表示 D 有否决权 当前 R 要被否决
        // flag == 0 没人会被否决
        int flag = 0;
        char[] senates = senate.toCharArray();
        while (R && D){
            R = false;
            D = false;
            for (int i = 0; i < n; i++){
                if (senates[i] == 'R'){
                    if (flag < 0) {
                        senates[i] = '0';
                    }else{
                        R = true;
                    }
                    flag++;
                }
                if (senates[i] == 'D'){
                    if (flag > 0){
                        senates[i] = '0';
                    }else{
                        D = true;
                    }
                    flag--;
                }
            }
        }

        return R ? "Radiant" : "Dire";
    }
}
