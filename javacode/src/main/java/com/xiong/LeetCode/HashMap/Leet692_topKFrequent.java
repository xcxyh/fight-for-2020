package com.xiong.LeetCode.HashMap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/5/20 12:52
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet692_topKFrequent {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {

            map.put(word, map.getOrDefault(word, 0) + 1);


        }

        int n = map.keySet().size();

        String[] arr = new String[n];
        int i = 0;
        for (String ss : map.keySet()) {
            arr[i++] = ss;
        }

        Arrays.sort(arr, (a, b) -> map.get(a) == map.get(b)? a.compareTo(b) : map.get(b) - map.get(a) );

        List<String> ans = new ArrayList<>();
        i = 0;
        while (k-- > 0) {
            ans.add(arr[i++]);
        }

        return ans;
    }

    public List<String> topKFrequent_steam(String[] words, int k) {
        return Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    if (o1.getValue().equals(o2.getValue())) {
                        return o1.getKey().compareTo(o2.getKey());
                    } else {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                })
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }
}
