package com.xiong.Kakou.entity;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/6 11:12
 * @description：
 * @modified By：
 * @version: $
 */
public class Graph {
    //点集，边集
    public HashMap<Integer, Node> nodes;//点的编号，实际对应的点
    public Set<Edge> edges;
    public Graph(){
        nodes = new HashMap<Integer, Node>();
        edges = new HashSet<Edge>();
    }
}
