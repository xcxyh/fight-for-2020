package com.xiong.Kakou.util;


import com.xiong.Kakou.entity.Edge;
import com.xiong.Kakou.entity.Graph;
import com.xiong.Kakou.entity.Node;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/6 11:12
 * @description：
 * @modified By：
 * @version: $
 */
public class GraphGenerator {
    //创建图
    public static Graph creatGraph(Integer[][]matrix){
        Graph graph = new Graph();
        for(int i = 0;i < matrix.length;i++){
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            //如果没有from点就建立一个
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from, new Node(from));
            }
            //如果没有to点就建立一个
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to, new Node(to));
            }
            //获取起始节点，终止节点
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            //新建一条from到to 的边
            Edge newEdge = new Edge(weight, fromNode, toNode);
            //fromNode与toNode建立关联，将toNode放到fromNode的next集合
            fromNode.nexts.add(toNode);//graph.nodes.get(from).nextx.add(toNode);
            //改变fromNode与toNode的入度与出度
            fromNode.out++;
            toNode.in++;
            //将建立好的边加入到边集（Graph,Node）
            graph.edges.add(newEdge);
            fromNode.edges.add(newEdge);
        }

        return graph;
    }
}
