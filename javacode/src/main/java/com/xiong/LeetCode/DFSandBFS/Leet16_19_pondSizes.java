package com.xiong.LeetCode.DFSandBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/27 17:55
 * @description：  面试题 16.19. 水域大小
 * @modified By：
 * @version: $
 */
public class Leet16_19_pondSizes {

    int rows ;
    int cols ;
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1},
            {1,1},{1,-1},{-1,1},{-1,-1}};
    public int[] pondSizes(int[][] land) {

        if (land == null || land.length == 0 || land[0].length == 0){
            return new int[]{};
        }

        rows= land.length;
        cols = land[0].length;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j  =0; j < cols; j++){
                if (land[i][j] == 0){
                    ans.add(dfs(land, i, j));
                }
            }
        }

        int[] arr = new int[ans.size()];

        int i  = 0;

        for(int x : ans){
            arr[i++] = x;
        }
        Arrays.sort(arr);
        return arr;
    }

    private int dfs(int[][] land, int i , int j){

        if (i < 0 || i >= rows || j < 0 || j >= cols){
            return 0;
        }

        if (land[i][j] != 0) {
            return 0;
        }

        land[i][j] = -1;

        int count = 1;

        for(int[] d : dir){
            int x = i + d[0];
            int y = j  + d[1];

            count += dfs(land, x , y);
        }

        return count;


    }
}
