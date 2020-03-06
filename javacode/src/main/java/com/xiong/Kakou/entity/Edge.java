package com.xiong.Kakou.entity;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/6 11:14
 * @description：
 * @modified By：
 * @version: $
 */
public class Edge {
    //这个并不是邻接矩阵或者邻接表法，面试中更常用的是这种
    public  int weight;//权重
    public  Node from;//边的起点
    public  Node to;//边的终点
    public Edge(int weight,Node from,Node to){
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
