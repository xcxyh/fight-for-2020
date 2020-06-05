package com.xiong.Kakou.util;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @Title: Dijkstra.java
 * @Package:main.java.com.huawei
 * @Description:(作用)
 * @author: xcc
 * @date:2019年3月15日
 * @version:V1.0
 */
public class Dijkstra {
    private DiEdge[] edgeTo;
    private double[] distTo;
    private Map<Integer, Double> minDist; //  key : w , value : mindist 保存 从 起点 s 到 w 点的 最小距离 value

    private EdgeWeightedDiGraph<?> graph;

    private Map<Integer, double[]> latlonMap;

    //构造一个Dijkstra
    public Dijkstra(EdgeWeightedDiGraph<?> graph, Map<Integer, double[]> latlonMap) {
        edgeTo = new DiEdge[graph.vertexNum()]; // 边数组
        distTo = new double[graph.vertexNum()]; //距离数组
        minDist = new HashMap<>(); // 最小距离 map
        this.latlonMap = latlonMap;
        this.graph = graph;
        // init  距离数组  为 正无穷大
        for (int i = 0; i < graph.vertexNum(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY; // 1.0 / 0.0为INFINITY
        }

    }

    //构造一个Dijkstra
    public Dijkstra(EdgeWeightedDiGraph<?> graph) {
        edgeTo = new DiEdge[graph.vertexNum()]; // 边数组
        distTo = new double[graph.vertexNum()]; //距离数组
        minDist = new HashMap<>(); // 最小距离 map
        this.graph = graph;

        // init  距离数组  为 正无穷大
        for (int i = 0; i < graph.vertexNum(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY; // 1.0 / 0.0为INFINITY
        }

    }

    // 将  s 到  key 距离最小的 那个 key 删除 （相当于 访问过了，不再访问）， 并以 key 作为新的起点 进入下一轮
    private int delMin() {
        Set<Map.Entry<Integer, Double>> entries = minDist.entrySet();
        Map.Entry<Integer, Double> min = entries.stream().min(Comparator.comparing(Map.Entry::getValue)).get();
        int key = min.getKey();
        minDist.remove(key);
        return key;
    }

    /**
     * 传入 图 和  当前点
     */
    //松弛函数  即更新 distTo 数组的 函数
    private void relax(EdgeWeightedDiGraph<?> graph, int v) {


        for (DiEdge edge : graph.adj(v)) {  // 遍历 当前点的所有边
            int w = edge.to(); // 终点
            if (distTo[v] + edge.weight() < distTo[w]) {  // 总体最小  就更新
                //更新
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge; // 记录这条边 作为 最短路径中的 一条边
                //更新 从起点 s 到 当前 点 的 最小距离
                if (minDist.containsKey(w)) {
                    minDist.replace(w, distTo[w]);
                } else {
                    minDist.put(w, distTo[w]);
                }
            }
        }
    }


    // 返回 从 s 到 v 的 最短距离
    public double distTo(int s, int v) {
        // 到自己距离为0
        distTo[s] = 0.0;
        relax(graph, s); // 求出 起点 与 起点直接相连的点，之间的距离
        while (!minDist.isEmpty()) {
            relax(graph, delMin());
        }

        return distTo[v] == Double.POSITIVE_INFINITY ? -1 : distTo[v];
    }

    // 改进
    //松弛函数  即更新 distTo 数组的 函数
    private void relax(EdgeWeightedDiGraph<?> graph, int v, double[] range) {

        for (DiEdge edge : graph.adj(v)) {  // 遍历 当前点的所有边
            int w = edge.to(); // 终点
            //todo  改进：不再是遍历所有的终点，而是首先判断点 w 是否在 矩形搜索范围内，如果不在，直接跳过

            double[] latlon_w = latlonMap.get(w);

            boolean flag = PointUtil.isWithinRange(range, latlon_w);
            if (flag) {
                if (distTo[v] + edge.weight() < distTo[w]) {  // 总体最小  就更新
                    //更新
                    distTo[w] = distTo[v] + edge.weight();
                    edgeTo[w] = edge; // 记录这条边 作为 最短路径中的 一条边
                    //更新 从起点 s 到 当前 点 的 最小距离
                    if (minDist.containsKey(w)) {
                        minDist.replace(w, distTo[w]);
                    } else {
                        minDist.put(w, distTo[w]);
                    }
                }
            }
        }
    }

    // 新的 方法
    public double distTo(int s, int v, double[] range) {
        // 到自己距离为0
        distTo[s] = 0.0;
        relax(graph, s, range); // 求出 起点 与 起点直接相连的点，之间的距离
        while (!minDist.isEmpty()) {
            relax(graph, delMin(), range);
        }

        return distTo[v] == Double.POSITIVE_INFINITY ? -1 : distTo[v];
    }

    // 判断 v 在此次 求解中 是否  可达了
    public boolean hasPathTo(int v) {
        return distTo[v] != Double.POSITIVE_INFINITY;
    }


    // 返回 从 s 到 v 的最短路径 经过的 所有边
    public Iterable<DiEdge> fromTopath(int s, int v) {
        // 到起点距离为0
        distTo[s] = 0.0;
        relax(graph, s);
        while (!minDist.isEmpty()) {
            relax(graph, delMin());
        }

        // 存在最短路径 返回 所有边
        if (hasPathTo(v)) {
            LinkedList<DiEdge> path = new LinkedList<>();
            for (DiEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()]) {
                path.push(edge);
            }
            return path;
        }
        //否则 返回null
        return null;
    }
}
