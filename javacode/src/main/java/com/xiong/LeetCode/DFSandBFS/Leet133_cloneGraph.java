package com.xiong.LeetCode.DFSandBFS;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/20 11:33
 * @description：  133 克隆图
 * @modified By：
 * @version: $
 */
public class Leet133_cloneGraph {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors = Arrays.asList(node2, node4);

        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);

        new Leet133_cloneGraph().cloneGraph(node1);
    }

    public Node cloneGraph(Node node) {


        // 原 node  ---- 新 node
        Map<Node, Node> visited = new HashMap<>();

        return dfs(node, visited);

    }

    private Node dfs(Node node, Map<Node, Node> visited) {

        if (node == null){
            return null;
        }

        if (visited.containsKey(node)){
            return visited.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<>());

        visited.put(node, clone);

        for(Node n : node.neighbors){
            clone.neighbors.add(dfs(n, visited));
        }
        return clone;
    }

    static class Node {
        int val;
        List<Node> neighbors;

        Node(int _val) {
            val = _val;
        }

        Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}