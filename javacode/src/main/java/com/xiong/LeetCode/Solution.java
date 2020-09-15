package com.xiong.LeetCode;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/19 9:38
 * @description：t
 * @modified By：
 * @version: $
 */
public class Solution {
    public static void main(String[] args) {

        drawLots();
    }

    // 抽签
    private static void drawLots(){
        // 实例化随机数生成器
        Random random = new Random();

        String[] name = new String[4];
        name[0] = "周成浩";
        name[1] = "熊聪聪";
        name[2] = "汤涛";
        name[3] = "康文豪";

        Set<Integer> set = new HashSet<>();
        //选出4个人
        while (true) {
            // 将这四个人的名字打印出来
            if (set.size() == 4){
                break;
            }
            int index = random.nextInt(4);
            if (!set.contains(index)){
                set.add(index);
                System.out.println(name[index]);
            }
        }
    }


}