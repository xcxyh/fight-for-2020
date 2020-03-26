package com.xiong.LeetCode.RaceOfWeek;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/22 12:19
 * @description： 第 181 场周赛
 * @modified By：
 * @version: $
 */
public class Race_181 {
    public static void main(String[] args) {
        Race_181 race = new Race_181();
        System.out.println(race.sumFourDivisors(new int[]{21, 21}));

        System.out.println(race.longestPrefix_KMP("ababab"));
    }

    //第一题： 通过
    public int[] createTargetArray(int[] nums, int[] index) {
        if (nums.length <= 1) {
            return nums;
        }
        int len = nums.length;
        int[] target = new int[len];
        //遍历 index
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (index[i] >= index[j]) {
                    index[i]++;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            target[index[i]] = nums[i];
        }
        return target;
    }

    // 第二题 ： 通过
    public int sumFourDivisors(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int sum = 0;
            int count = 2;
            sum += temp + 1;
            for (int j = 2; j <= Math.sqrt(temp); j++) {
                if (temp % j == 0) {
                    if (j == temp / j) {
                        sum += j;
                        count++;
                    } else {
                        sum += j;
                        sum += temp / j;
                        count += 2;
                    }
                }
            }
            if (count == 4) {
                max += sum;
            }
        }
        return max;
    }

    //第三题： 没做 (别人写的 广度优先遍历)
    int[][][] dirs;

    public boolean hasValidPath(int[][] grid) {
        int m = grid[0].length; //列数
        int n = grid.length; //行数
        dirs = new int[7][2][2];
        dirs[1] = new int[][]{{0, -1}, {0, 1}};  // 左 （0，-1） 右 （0，1）
        dirs[2] = new int[][]{{-1, 0}, {1, 0}};  // 上   下
        dirs[3] = new int[][]{{0, -1}, {1, 0}};
        dirs[4] = new int[][]{{1, 0}, {0, 1}}; //下 右
        dirs[5] = new int[][]{{0, -1}, {-1, 0}};
        dirs[6] = new int[][]{{-1, 0}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0}); //起点 左上角
        boolean[] visit = new boolean[n * m]; //也可以使用二维数组存储 更容易理解
        visit[0] = true;
        while (!q.isEmpty()) { // 广度优先遍历 BFS
            int[] top = q.poll();
            int x = top[0];
            int y = top[1];
            for (int[] d : dirs[grid[x][y]]) { //尝试当前点的两个方向
                int dx = x + d[0];
                int dy = y + d[1];
                if (dx < 0 || dx >= n || dy < 0 || dy >= m || visit[dx * m + dy]) continue;
                for (int[] d2 : dirs[grid[dx][dy]]) { //判断走向的那个节点
                    if (d2[0] == -d[0] && d2[1] == -d[1]) { //方向相反 即为连通  例如 上 下
                        visit[dx * m + dy] = true;
                        q.add(new int[]{dx, dy});
                    }
                }
            }
        }
        return visit[(n - 1) * m + m - 1];
    }

    //第四题： 超时了
    public String longestPrefix(String s) {

        if (s.length() <= 1) {
            return "";
        }
        String subString = "";
        int max = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.substring(0, i + 1).equals(s.substring(s.length() - i - 1)) && i + 1 > max) {
                max = i + 1;
                subString = s.substring(0, i + 1);
            }
        }
        return subString;
    }

    //第四题：KMP 算法
    public static String longestPrefix_KMP(String s) {
        if (s.length() <= 1)
            return "";
        int n = s.length();
        //对于模式串T，next 数组的长度 比 T的长度大1，
        // next[j]代表了T的前j个字符组成的子串中，其前缀和后缀的最长公共串的长度。
        int[] next = new int[n + 1];
        int pLen = s.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j <= pLen - 1) {
            if (k == -1 || s.charAt(j) == s.charAt(k)) {
                ++k;
                ++j;
                next[j] = k;
            } else {
                k = next[k];//
            }
        }
        int p2 = next[next.length - 1];
        return s.substring(s.length() - p2);
    }

}
