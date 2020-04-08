package com.xiong.LeetCode.DailyProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/7 11:45
 * @description：  面试题 01.07. 旋转矩阵
 *
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。
 * 请你设计一种算法，将图像旋转 90 度。
 * @modified By：
 * @version: $
 */
public class D0107_rotateMatrix {

    //找规律：先沿左下对角线翻转  再沿 竖中线翻转
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length <= 1){
            return;
        }
        int N = matrix.length;
        //先沿左下对角线翻转  再沿 竖中线翻转
        for(int i = 0; i < N; i++){
            for(int j = i; j < N; j++){
                //对角翻转
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //竖中线翻转
        for(int i =0; i< N; i++){
            for(int j = 0; j < N/2; j++){
                //竖中线翻转
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - 1- j];
                matrix[i][N - 1- j] = temp;
            }
        }
    }

}
