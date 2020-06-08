package com.xiong.LeetCode.StringsProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/7 10:47
 * @description：   127. 单词接龙
 * @modified By：
 * @version: $
 */
public class Leet127_ladderLength {

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog");

        System.out.println(new Leet127_ladderLength().ladderLength(beginWord, endWord, wordList));
    }
    // 终于对了  难顶哦
    //BFS 搜索就行
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        //BFS 得出层数
        Queue<String> q = new LinkedList<>();
        int len = wordList.size();
        boolean[] visited = new boolean[len];
        q.offer(beginWord);
        if (wordList.contains(beginWord)){
            visited[wordList.indexOf(beginWord)] = true;
        }
        int ans = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String temp = q.poll();

                for(int i = 0; i < len; i++){
                    String next = wordList.get(i);
                    if (!visited[i] && canChange(temp , next)){
                        q.add(next);
                        visited[i] = true;
                    }
                }
            }
            ans++;
            if (visited[wordList.indexOf(endWord)]) {
                return ans;
            }
        }

        return 0;

    }

    private boolean canChange(String cur, String next){
        int count = 0;
        for(int i = 0; i < cur.length(); i++){
            if (cur.charAt(i) != next.charAt(i)){
                count++;
            }
        }
        return count == 1;
    }
}
