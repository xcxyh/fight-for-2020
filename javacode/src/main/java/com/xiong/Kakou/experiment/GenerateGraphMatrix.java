package com.xiong.Kakou.experiment;

import com.xiong.Kakou.entity.*;
import com.xiong.Kakou.service.LinkService;
import com.xiong.Kakou.service.PointServcie;
import com.xiong.Kakou.util.Dijkstra;
import com.xiong.Kakou.util.EdgeWeightedDiGraph;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/6 11:16
 * @description：
 * @modified By：
 * @version: $
 */
public class GenerateGraphMatrix {

    static PointServcie pointServcie = new PointServcie();

    static LinkService linkService = new LinkService();
    //处理节点 新建map 存储 node 和 编号的对应关系
    static Map<String, Integer> nodeMap = new HashMap<>();

    public static void main(String[] args) {
        //生成 矩阵  weight(link长度)  from(from_node)  to(to_node)
        EdgeWeightedDiGraph<String> graph = generatorGraph();

        Dijkstra dijkstra = new Dijkstra(graph);//新建一个dj
        int from = nodeMap.get("7942");
        int to = nodeMap.get("8064");

        String str = dijkstra.fromTopath(from, to).toString();
        System.out.println("from " + from + " to " + to + " shortest: " + str);
        System.out.println();
    }

    /**
     * @author: xiongcong
     * @Date: 2020/3/6 12:10
     * @Description: 生成graph
     */
    public static EdgeWeightedDiGraph<String> generatorGraph() {
        int[][] edges;
        List<String> vertexInfo;
        int[] weight;
        List<LinkModel> allLink = linkService.selectAllLink();
        int size = allLink.size();
        //初始化
        edges = new int[size][2];
        weight = new int[size];
        vertexInfo = new ArrayList<>();

        int k = 0;
        for (int i = 0; i < size; i++) {
            LinkModel linkModel = allLink.get(i);
            String node1 = linkModel.getFrom_node();
            String node2 = linkModel.getTo_node();

            if (nodeMap.get(node1) == null) {
                nodeMap.put(node1, k++);
            }
            if (nodeMap.get(node2) == null) {
                nodeMap.put(node2, k++);
            }
        }
        //将编号 添加到 vertexInfo
        for (int i = 0; i < k; i++) {
            vertexInfo.add(i + "");
        }

        //生成图  将node 转成 编号
        for (int i = 0; i < size; i++) {
            LinkModel linkModel = allLink.get(i);
            //取出link的长度length 作为权重
            float len = linkModel.getLink_length();
            weight[i] = (int) len; // weight
            edges[i][0] = nodeMap.get(linkModel.getFrom_node()); //from
            edges[i][1] = nodeMap.get(linkModel.getTo_node());  //to
        }


        EdgeWeightedDiGraph<String> graph = new EdgeWeightedDiGraph<>(vertexInfo, edges, weight);

        System.out.println("该图的邻接表为\n" + graph);
        System.out.println("该图的所有边：" + graph.edges());
        return graph;
    }

}
