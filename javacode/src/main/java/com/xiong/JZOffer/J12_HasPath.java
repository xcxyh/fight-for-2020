package com.xiong.JZOffer;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/12/28 15:45
 * @description： 题目描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入该格子。
 * @modified By：
 * @version: $
 */
public class J12_HasPath {
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};//左 右 上 下
    private int rows;
    private int cols;

    public static void main(String[] args) {
        char[] array = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
       // char[] str = {'b', 'c', 'c', 'e', 'd'};
        char[] str = {'a', 'b', 'c', 'b'};
        J12_HasPath hs = new J12_HasPath();
        System.out.println(hs.hasPath(array, 3, 4, str));
    }

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(matrix, str, marked, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/12/28 16:24
     *  @Description: 使用回溯法
     *  回溯是深度优先搜索的一种特例，它在一次搜索过程中需要设置一些本次搜索过程的局部状态，并在本次搜索结束之后清除状态。
     *
     */
    private boolean backtracking(char[][] matrix, char[] str,
                                 boolean[][] marked, int pathLen, int r, int c) {
        //基线条件
        if (pathLen == str.length) {
            return true;
        }

        //基线条件
        if (r < 0 || r >= rows || c < 0 || c >= cols
                || matrix[r][c] != str[pathLen] || marked[r][c]) {
            return false;
        }

        marked[r][c] = true;//走过的位置 标记为 true
        System.out.println(matrix[r][c]);
        //遍历一个元素的上下左右四个位置
        for (int[] n : next) {
            if (backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1])) {
                return true;
            }
        }
        //在一次搜索结束后 未找到 清除标记，
        marked[r][c] = false;

        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = array[idx++];
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
        return matrix;
    }


}
