package com.xiong.JDK8NewFeaturesDemo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/30 17:46
 * @description： 常用的 lambda 表达式
 * @modified By：
 * @version: $
 */
public class LambdaExpDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        //list
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        // 简化为 lambda
        Collections.sort(names, (a, b) -> b.compareTo(a));
        // 再次简化
        Collections.sort(names, Comparator.reverseOrder());


        //二维数组
        int[][] arr = new int[][]{{1, 3}, {2, 4}, {5, 3}, {2, 7}, {5, 8}, {4, 9}};

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
    }
}
