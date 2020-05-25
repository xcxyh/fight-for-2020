package com.xiong.LeetCode.RaceOfWeek;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/5/17 12:36
 * @description：
 * @modified By：
 * @version: $
 */
public class Race_189 {

    // 1  5412. 在既定时间做作业的学生人数
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int len = startTime.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                ans++;
            }
        }
        return ans;
    }

    //2 5413. 重新排列句子中的单词
    public String arrangeWords(String text) {
        String[] strs = text.split(" ");

        char c = Character.toLowerCase(strs[0].charAt(0));

        strs[0] = c + strs[0].substring(1);

        Arrays.sort(strs, (o1, o2) -> o1.length() - o2.length());

        char c1 = Character.toUpperCase(strs[0].charAt(0));


        strs[0] = c1 + strs[0].substring(1);

        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    //3  5414. 收藏清单
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        // 转成 set 集合 就不会超时了
        List<Set<String>> setList = new ArrayList<>();
        for (List<String> strList : favoriteCompanies) {
            Set<String> set = new HashSet<>(strList);
            setList.add(set);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < setList.size(); i++) {
            boolean flag = true;
            Set<String> list = setList.get(i);

            for (int j = 0; j < setList.size(); j++) {

                if (i != j && setList.get(j).containsAll(list)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans.add(i);
            }

        }
        return ans;
    }

    //4  5415. 圆形靶内的最大飞镖数量
    // 已知两点求 圆心
    // 求圆心位置 ，圆心位置不是 两点的中点 ， 而是中垂线上的某两点
    public int numPoints(int[][] points, int r) {
        int len = points.length;
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) { // 从 i 开始

                int count = 0;
                double[][] centers = changeCenter(points[i], points[j], r);
                for (double[] center : centers) {

                    for (int[] p : points) {
                        if (distance(center, p) <= r) {
                            count++;
                        }
                    }
                    ans = Math.max(ans, count);
                }


            }
        }

        return ans;
    }

    private int distance(double[] point1, int[] point2) {

        return (int) Math.sqrt((point1[0] - point2[0]) * (point1[0] - point2[0])
                + (point1[1] - point2[1]) * (point1[1] - point2[1]));
    }

    // 已知半径 和 两点 求圆心
    private double[][] changeCenter(int[] point1, int[] point2, int r) {

        int x1 = point1[0];
        int y1 = point1[1];
        int x2 = point2[0];
        int y2 = point2[1];
        //todo
        int d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2); // |ab|^2


        //圆心1
        double cx1 = (x1 + x2) / 2.0 + (y2 - y1) * Math.sqrt((r * r - d / 4.0) / d);
        double cy1 = (y1 + y2) / 2.0 - (x2 - x1) * Math.sqrt((r * r - d / 4.0) / d);

        //圆心2
        double cx2 = (x1 + x2) / 2.0 - (y2 - y1) * Math.sqrt((r * r - d / 4.0) / d);
        double cy2 = (y1 + y2) / 2.0 + (x2 - x1) * Math.sqrt((r * r - d / 4.0) / d);


        return new double[][]{{cx1, cy1}, {cx2,cy2}};
    }
}
