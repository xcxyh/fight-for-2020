package com.xiong.LeetCode.BinarySearch;

import com.xiong.LeetCode.Solution;

import java.util.Arrays;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/8 12:35
 * @description：    1723. 完成所有工作的最短时间  二分 + 回溯
 * @modified By：
 * @version: $
 */
public class Leet1723_minimumTimeRequired {



    public int minimumTimeRequired(int[] jobs, int k) {
        int n = jobs.length;

        int left = 0;
        int right = 0;

        for (int job : jobs) {

            left = Math.max(left, job);

            right += job;

        }

        Arrays.sort(jobs);
        int low = 0, high = n - 1;
        // 倒序 ， 从 大到小 找
        while (low < high) {
            int temp = jobs[low];
            jobs[low] = jobs[high];
            jobs[high] = temp;
            low++;
            high--;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (check(jobs, k, mid)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return left;

    }
    // 分成 k 组，看看在这个limit 下 能不能安排完工作
    public boolean check(int[] jobs, int k, int limit) {
        //workloads[i] 代表第i个工人所用的时间
        int[] workloads = new int[k];
        return backtrack(jobs, workloads, 0, limit);
    }

    public boolean backtrack(int[] jobs, int[] workloads, int i, int limit) {
        if (i >= jobs.length) {
            return true;
        }
        int cur = jobs[i];
        for (int j = 0; j < workloads.length; ++j) {
            if (workloads[j] + cur <= limit) {
                workloads[j] += cur;
                if (backtrack(jobs, workloads, i + 1, limit)) {
                    return true;
                }
                workloads[j] -= cur;
            }
            // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
            // 剪枝  不然超时
            if (workloads[j] == 0) {
                break;
            }
        }
        return false;
    }

}
