package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/1/3 10:23
 * @description： 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @modified By：
 * @version: $
 */
public class MovingCount_13 {
    //移动方向 左右上下
    private static final int[][] next = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;
    private int threshold;
    private int[][] digitSum;
    private int count = 0;//结果

    public static void main(String[] args) {
        MovingCount_13 m = new MovingCount_13();
        System.out.println(m.movingCount(18, 50, 40));//1810
    }

    /**
     * @author: xiongcong
     * @Date: 2020/1/3 10:55
     * @Description: 求解机器人移动范围
     */
    public int movingCount(int threshold, int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;
        initalDigitSum();
        boolean[][] marked = new boolean[rows][cols];  //标记走过的位置
        dfs(marked, 0, 0);
        return count;
    }

    /**
     * @author: xiongcong
     * @Date: 2020/1/3 10:53
     * @Description: 深度优先遍历 求解
     */
    private void dfs(boolean[][] marked, int r, int c) {
        //边界条件  注意 >=  r 和 c 必须小于 rows 和 cols
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c]) {
            return;
        }
        //走过的位置标记为true
        marked[r][c] = true;
        //基线条件
        if (digitSum[r][c] > threshold) {
            return;
        }
        //计数
        count++;
        //遍历四个方向
        for (int[] n : next) {
            dfs(marked, r + n[0], c + n[1]);
        }
    }

    /**
     * @author: xiongcong
     * @Date: 2020/1/3 10:52
     * @Description: 计算所有的数位之和，存在 digitSum 这个二维数组中
     */
    private void initalDigitSum() {

        //把 从 0 到 最大 的数的 数位之和 都求出来 放入 digitalOne
        int[] digitalOne = new int[Math.max(rows, cols)];
        for (int i = 0; i < digitalOne.length; i++) {
            int n = i;
            while (n > 0) {
                digitalOne[i] += n % 10;
                n = n / 10;
            }
        }
        //计算所有位置上的数位之和
        this.digitSum = new int[rows][cols]; //初始化 这个 二维数组
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                digitSum[i][j] = digitalOne[i] + digitalOne[j]; //横坐标数位之和 + 纵坐标数位之和
            }
        }
    }
}
