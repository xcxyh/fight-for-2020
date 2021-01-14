package com.xiong.LeetCode.UnionFind;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/1/6 10:25
 * @description： 399. 除法求值  带权并查集问题
 * @modified By：
 * @version: $
 */
public class Leet399_calcEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = 0;
        // 将变量从字符节点 转换成 数字节点
        Map<String, Integer> map = new HashMap<>();
        for (List<String> equation : equations) {
            if (!map.containsKey(equation.get(0))) {
                map.put(equation.get(0), n++);
            }
            if (!map.containsKey(equation.get(1))) {
                map.put(equation.get(1), n++);
            }
        }

        int[] f = new int[n];
        double[] w = new double[n];
        Arrays.fill(w, 1.0);
        //并查集 初始化，所有节点的父节点为自己本身
        for(int i = 0; i < n; i++) {
            f[i] = i;
        }
        //
        for(int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];

            int va = map.get(equation.get(0));
            int vb = map.get(equation.get(1));

            mergeGroup(f, w, va, vb, value);
        }
        //
        int queriesLen = queries.size();
        double[] ret = new double[queriesLen];

        for (int i = 0; i < queriesLen; i++) {
            double val = -1.0;
            List<String> query = queries.get(i);
            if (map.containsKey(query.get(0)) && map.containsKey(query.get(1))){
                int va = map.get(query.get(0));
                int vb = map.get(query.get(1));
                int fa = find(f, w, va);
                int fb = find(f, w, vb);

                if (fa == fb) {
                    val = w[va] / w[vb];
                }
            }
            ret[i] = val;
        }
        return ret;
    }

    private void mergeGroup(int[] f, double[] w, int va, int vb, double value) {
        int fa = find(f, w, va);
        int fb = find(f, w, vb);

        if(fa != fb) {
            f[fa] = fb;
            // 更新权重
            w[fa] = value * w[vb] / w[va];
        }

    }

    private int find(int[] f, double[] w, int x) {

        if (f[x] != x) {
            int father = find(f, w, f[x]);
            //更新权重
            w[x] = w[x] * w[f[x]];
            f[x] = father;
        }
        return f[x];
    }



    // 官方答案
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<String, Integer>();

        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }
        int[] f = new int[nvars];
        double[] w = new double[nvars];
        Arrays.fill(w, 1.0);
        for (int i = 0; i < nvars; i++) {
            f[i] = i;
        }

        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
            merge(f, w, va, vb, values[i]);
        }
        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                int fa = findf(f, w, ia), fb = findf(f, w, ib);
                if (fa == fb) {
                    result = w[ia] / w[ib];
                }
            }
            ret[i] = result;
        }
        return ret;
    }

    private void merge(int[] f, double[] w, int x, int y, double val) {
        int fx = findf(f, w, x);
        int fy = findf(f, w, y);
        f[fx] = fy;
        w[fx] = val * w[y] / w[x];
    }

    private int findf(int[] f, double[] w, int x) {
        if (f[x] != x) {
            int father = findf(f, w, f[x]);
            w[x] = w[x] * w[f[x]];
            f[x] = father;
        }
        return f[x];
    }
}
