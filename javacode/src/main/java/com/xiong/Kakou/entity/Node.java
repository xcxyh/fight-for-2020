package com.xiong.Kakou.entity;

import java.util.ArrayList;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/6 11:13
 * @description：
 * @modified By：
 * @version: $
 */
public class Node {
    public int value;//值
    public int in;//入度，多少个节点指向我
    public int out;//出度，我指向多少个节点
    public ArrayList<Node> nexts;//从我出发能到达的邻居节点
    public ArrayList<Edge>edges;//从我出发 的边的集合（from）
    public Node(int value){
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
    }
}
