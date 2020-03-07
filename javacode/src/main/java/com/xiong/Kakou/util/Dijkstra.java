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
    private Map<Integer, Double> minDist;
    private EdgeWeightedDiGraph<?> graph;
  
    public Dijkstra(EdgeWeightedDiGraph<?> graph) {
        edgeTo = new DiEdge[graph.vertexNum()];
        distTo = new double[graph.vertexNum()];
        minDist = new HashMap<>();
        this.graph=graph;
  
        for (int i = 0; i < graph.vertexNum(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY; // 1.0 / 0.0为INFINITY
        }
     
    }

    private int delMin() {
        Set<Map.Entry<Integer, Double>> entries = minDist.entrySet();
        Map.Entry<Integer, Double> min = entries.stream().min(Comparator.comparing(Map.Entry::getValue)).get();
        int key = min.getKey();
        minDist.remove(key);
        return key;
    }

    private void relax(EdgeWeightedDiGraph<?> graph, int v) {
        for (DiEdge edge : graph.adj(v)) {
            int w = edge.to();
            if (distTo[v] + edge.weight() < distTo[w]) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;
                if (minDist.containsKey(w)) {
                    minDist.replace(w, distTo[w]);
                } else {
                    minDist.put(w, distTo[w]);
                }
            }
        }
    }

    public double distTo(int s,int v) {
    	 // 到起点距离为0
        distTo[s] = 0.0;
        relax(graph, s);
        while (!minDist.isEmpty()) {
            relax(graph, delMin());
        }
    	
        if (hasPathTo(v)) {
            LinkedList<DiEdge> path = new LinkedList<>();
            for (DiEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()]) {
                path.push(edge);
            }
            //return path;
        }
        //return null;
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] != Double.POSITIVE_INFINITY;
    }

    public Iterable<DiEdge> fromTopath(int s,int v) {
    	   // 到起点距离为0
        distTo[s] = 0.0;
        relax(graph, s);
        while (!minDist.isEmpty()) {
            relax(graph, delMin());
        }
    	
        if (hasPathTo(v)) {
            LinkedList<DiEdge> path = new LinkedList<>();
            for (DiEdge edge = edgeTo[v]; edge != null; edge = edgeTo[edge.from()]) {
                path.push(edge);
            }
            return path;
        }
        return null;
    }
}
