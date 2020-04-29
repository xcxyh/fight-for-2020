package com.xiong.LeetCode.StackAndQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/20 11:33
 * @description：  133 克隆图
 * @modified By：
 * @version: $
 */
public class Leet133_cloneGraph {

    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        Map<Node, Node> visited = new HashMap<>();
        return  dfs(node,visited);
    }

    private Node dfs(Node node , Map<Node, Node> visited){

        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)){
            return visited.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone); // 克隆了的 保存起来

        for (Node n : node.neighbors){
            clone.neighbors.add(dfs(n, visited));
        }
        return clone;
    }

}

class Node {
    public int val;
    List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}