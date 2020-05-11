package com.xiong.LeetCode.StackAndQueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/5 8:53
 * @description： 785. 判断二分图
 * @modified By：
 * @version: $
 */
public class Leet785_isBipartite {

    public boolean isBipartite(int[][] graph) {
        //深度优先遍历 着色
        int size = graph.length;

        // 0 1 两种颜色  -1 为未着色
        int[] color = new int[size];
        Arrays.fill(color, -1);
        for(int i = 0; i < size; i++){
            if (color[i] == -1){
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                color[i]=0;
                while(!stack.isEmpty()){
                    int node = stack.pop();
                    for(int n : graph[node]){

                        if (color[n] == -1){
                            stack.push(n);
                            color[n] = color[node] ^ 1; //反色
                        }else if(color[n] == color[node]){
                            return false;
                        }

                    }
                }
            }
        }

        return true;
    }
}
