package com.xiong.Kakou.util;

import java.util.*;

/**
 * @Title: EdgeWeightedDiGraph.java
 * @Package:main.java.com.huawei
 * @Description:(作用)
 * @author: xcc
 * @date:2019年3月15日
 * @version:V1.0
 */
public class EdgeWeightedDiGraph<Item> {
    private int vertexNum;  //顶点数
    private int edgeNum; // 边数
    // 邻接表
    // 顶点 是从 0 1 2 3 4 5 6  ... 进行编号的
    private List<List<DiEdge>> adj;  // DiEdge 为有向边类
    // 顶点信息
    private List<Item> vertexInfo;

    public EdgeWeightedDiGraph(List<Item> vertexInfo) {
        this.vertexInfo = vertexInfo;
        this.vertexNum = vertexInfo.size();
        adj = new ArrayList<>();
        for (int i = 0; i < vertexNum; i++) {
            adj.add(new LinkedList<>());
        }
    }


    public EdgeWeightedDiGraph(List<Item> vertexInfo, int[][] edges, int[] weight) {
        this(vertexInfo);
        for (int i = 0; i < edges.length; i++) {
            DiEdge edge = new DiEdge(edges[i][0], edges[i][1], weight[i]);
            addDiEdge(edge);
        }
    }

    public EdgeWeightedDiGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        adj = new ArrayList<>();
        for (int i = 0; i < vertexNum; i++) {
            adj.add(new LinkedList<>());
        }
    }

    public EdgeWeightedDiGraph(int vertexNum, int[][] edges, int[] weight) {
        this(vertexNum);
        for (int i = 0; i < edges.length; i++) {
            DiEdge edge = new DiEdge(edges[i][0], edges[i][1], weight[i]);
            addDiEdge(edge);
        }
    }

    public void addDiEdge(DiEdge edge) {
        // adj 中保存 以 index 为起点的 所有 边
        adj.get(edge.from()).add(edge);
        edgeNum++;
    }

    // 返回与某个顶点依附的所有边
    public Iterable<DiEdge> adj(int v) {
        return adj.get(v);
    }


    //返回 该图中 以 所有点为 起点的 所有边
    public List<DiEdge> edges() {
        List<DiEdge> edges = new LinkedList<>();
        for (int i = 0; i < vertexNum; i++) { //遍历所有顶点
            for (DiEdge e : adj(i)) {
                edges.add(e);
            }
        }
        return edges;
    }

    public int vertexNum() {
        return vertexNum;
    }

    public int edgeNum() {
        return edgeNum;
    }

    public Item getVertexInfo(int i) {
        return vertexInfo.get(i);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(vertexNum).append("个顶点, ").append(edgeNum).append("条边。\n");
        for (int i = 0; i < vertexNum; i++) {
            // 例： 6: [6->2, 6->0, 6->4]
            sb.append(i).append(": ").append(adj.get(i)).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<String> vertexInfo = Arrays.asList("v0", "v1", "v2", "v3", "v4", "v5", "v6", "v7");
        int[][] edges = {{4, 5}, {5, 4}, {4, 7}, {5, 7}, {7, 5}, {5, 1}, {0, 4}, {0, 2},
                {7, 3}, {1, 3}, {2, 7}, {6, 2}, {3, 6}, {6, 0}, {6, 4}};

        int[] weight = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        EdgeWeightedDiGraph<String> graph = new EdgeWeightedDiGraph<>(vertexInfo, edges, weight);
        Dijkstra dijkstra = new Dijkstra(graph);//新建一个dj

        System.out.println(dijkstra.distTo(6, 7));

        Iterable<DiEdge> edgss =  dijkstra.fromTopath(6,7);
        Iterator<DiEdge> it = edgss.iterator();
        double length = 0.0;
        while (it.hasNext()) {
            length += it.next().weight();
        }
        System.out.println(length);
       // System.out.println("该图的邻接表为\n" + graph);
       // System.out.println("该图的所有边：" + graph.toString());

    }
}
