package com.xiong.LeetCode.MathProblems;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/17 9:34
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1232_checkStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int[] point1 = coordinates[0];
        int[] point2 = coordinates[1];

        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            if (!inLine(point1, point2, x, y)) {
                return false;
            }
        }

        return true;
    }

    private boolean inLine(int[] p1, int[] p2, int x, int y) {
        if (p1[0] == p2[0]) {
            return x == p1[0];
        }
        if (p1[1] == p2[1]) {
            return y == p1[1];
        }
        return (x - p1[0]) / (p2[0] - p1[0]) == (y - p1[1]) / (p2[1] - p1[1]);
    }

}
