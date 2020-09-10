package com.xiong.LeetCode.DFSandBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/31 9:17
 * @description： 841. 钥匙和房间
 * @modified By：
 * @version: $
 */
public class Leet841_canVisitAllRooms {

    public static void main(String[] args) {

        List<List<Integer>> rooms = new ArrayList<>();

        List<Integer> room1 = new ArrayList<>();
        room1.add(1);
        List<Integer> room2 = new ArrayList<>();
        room1.add(2);
        List<Integer> room3 = new ArrayList<>();
        room1.add(3);

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        canVisitAllRooms(rooms);
    }



    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();

        boolean[] visited = new boolean[n];

        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        while(!q.isEmpty()){

            int size = q.size();
            while(size-- > 0){
                int t = q.poll();
                if (visited[t]){
                    continue;
                }
                visited[t] = true;
                for(int next : rooms.get(t)){

                    q.offer(next);

                }
            }
        }

        for(boolean x : visited){
            if (!x){
                return false;
            }
        }
        return true;
    }
}
