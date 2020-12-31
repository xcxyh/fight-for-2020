package com.xiong.LeetCode.GreedyAlgorithm;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/12/7 12:51
 * @description： 861. 翻转矩阵后的得分
 * @modified By：
 * @version: $
 */
public class Leet861_matrixScore {


    public int matrixScore(int[][] A) {
        // 先所有行变 最大  然后所有列变最大
        // 行变规则：使最高位为1 ，列变规则：使 1 的数量多于 0

        int row = A.length;
        int col = A[0].length;

        for (int i = 0; i < row; i++){
            //行变规则：使最高位为1
            if (A[i][0] == 0){
                for (int j = 0; j < col; j++){
                    A[i][j] ^= 1;
                }
            }
        }
        // 统计每列 1 的个数
        int[] colSum = new int[col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                colSum[j] += A[i][j];
            }
        }

        //统计
        int sum = 0;
        int index = 1;
        for (int i = col - 1; i >= 0; i--) {
            //列变规则：使 1 的数量多于 0
            if (colSum[i] <= row / 2){
                colSum[i] = row - colSum[i];
            }

            sum += colSum[i] * index;
            index *= 2;
        }

        return sum;


    }
}
