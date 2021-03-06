package com.xiong.LeetCode.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2021/2/26 11:05
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet1178_findNumOfValidWords {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (String word : words) {

            int mask = 0;

            for (int i = 0; i < word.length(); i++) {
                int position = 1 << (word.charAt(i) - 'a');
                mask = mask | position;
            }

            freq.put(mask, freq.getOrDefault(mask, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        for (String puzzle : puzzles) {

            int total = 0;

            int mask = 0;

            for (int i = 1; i < 7; i++) {
                int pos = 1 << (puzzle.charAt(i) - 'a');
                mask = mask | pos;
            }

            // 求二进制表示所有子集，且包含第一个字母

            int subset = mask;

            while (subset != 0) {

                int s = subset | (1 << (puzzle.charAt(0) - 'a'));

                if (freq.containsKey(s)) {
                    total += freq.get(s);
                }
                subset = (subset - 1) & mask;
            }

            int first = 1 << (puzzle.charAt(0) - 'a');

            if (freq.containsKey(first)) {
                total += freq.get(first);
            }

            ans.add(total);

        }

        return ans;
    }
}
