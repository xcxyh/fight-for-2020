package com.xiong.LeetCode.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/27 10:44
 * @description：   332. 重新安排行程  类似的题：753. 破解保险箱，  欧拉回路 欧拉通路问题。
 * @modified By：
 * @version: $
 */
public class Leet332_findItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {

        //构造 graph
        Map<String, List<String>> graph = new HashMap<>();

        for(List<String> pairs : tickets){

            List<String> nbr = graph.getOrDefault(pairs.get(0), new ArrayList<>());
            nbr.add(pairs.get(1));
            graph.put(pairs.get(0), nbr);
        }

        // 排序 ，按字典序 对 nbr 排序
        graph.values().forEach(x -> x.sort(String::compareTo));

        List<String> ans = new ArrayList<>();

        dfs(graph, "JFK", ans);

        return ans;
    }

    private void dfs(Map<String, List<String>> graph, String cur, List<String> ans){

        List<String> nbr = graph.get(cur);

        while(nbr != null && nbr.size() > 0){
            String dest = nbr.remove(0);
            dfs(graph, dest, ans);
        }
        // 头插 ,如果当前节点 出度为 0
        ans.add(0, cur);

    }
}
