package com.xiong.logback;

import com.xiong.LeetCode.Solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/11 8:32
 * @description：
 * @modified By：
 * @version: $
 */
public class ZhongXin {
    public static void main(String[] args) throws Exception{
        String path ="H:\\Idea-workspace\\fight-for-2020\\javacode\\src\\main\\resources\\Example.csv";
        int[][] arr = readCSV(path);
        int nameNumber = 4;
        new ZhongXin().solution(arr, nameNumber);
    }

    private int solution(int[][] arr, int num) throws Exception{
        //有num 个名字的祭品最多有 max 个
        int count = 0;
        //先遍历部落A
        int rows = arr.length;
        int cols = arr[0].length;
        //统计arr中 组成 以 4 个点为 矩形的 矩形的个数
        //num 为 4 的情况 ：行与行相与 统计 1 的个数 n  C m 2

        for (int i = 1; i <rows ; i++) {
            for (int j = 0; j <cols ; j++) {
            }
        }

        return count;
    }
    //读取文件
    private static int[][] readCSV(String filePath){
        List<String[]> dataList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader( new FileReader(filePath));
            int lineNumber = 0,tokenNumber = 0;
            while((filePath = br.readLine()) != null) {
                lineNumber++;
                String[] result = filePath.split(",");
                dataList.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //转成数组
        int rows = dataList.size();
        int cols = dataList.get(0).length;
        int[][] ans = new int[rows][cols];
        for (int i = 0; i <rows ; i++) {
            String[] temp = dataList.get(i);
            for (int j = 0; j <cols ; j++) {
                ans[i][j] = Integer.parseInt(temp[j]);
            }
        }
        return ans;
    }
}
