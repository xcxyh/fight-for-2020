package com.xiong.Cache;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/4/13 9:58
 * @description：  355. 设计推特
 * @modified By：
 * @version: $
 */
public class Twitter {
    private Map<Integer, Tweet> tweetMap = new HashMap<>(); // map + 链表
    private Map<Integer, Set<Integer>> followMap = new HashMap<>();
    private int timestamp = 0;//全局时间戳

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        Tweet head = tweetMap.get(userId);
        Tweet temp = new Tweet(tweetId, timestamp);
        //头插法  放在链表的头部
        temp.next = head;
        head = temp;
        tweetMap.put(userId, head); //更新！！！！
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = followMap.get(userId);
        if (set == null) {
            set = new HashSet<>();
            set.add(userId);
            followMap.put(userId,set);
        }
        //K个有序链表的合并
        // 自动通过 timestamp 属性从大到小排序，容量为 set 的大小
        PriorityQueue<Tweet> pq = new PriorityQueue<>(set.size(),
                (a, b) -> (b.timestamp - a.timestamp));

        // 先将所有链表头节点插入优先级队列
        for (int id : set) {
            Tweet twt = tweetMap.get(id);
            if (twt == null) continue;
            pq.add(twt);
        }
        while (!pq.isEmpty()) {
            // 最多返回 10 条就够了
            if (res.size() == 10) break;
            // 弹出 time 值最大的（最近发表的）
            Tweet twt = pq.poll();
            res.add(twt.id);
            // 将下一篇 Tweet 插入进行排序
            if (twt.next != null)
                pq.add(twt.next);
        }
        //K个有序链表的合并 end
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {

        Set<Integer> set = followMap.get(followerId);
        if (set == null) {
            set = new HashSet<>();
            set.add(followerId);
        }
        set.add(followeeId);
        followMap.put(followerId, set);//更新！！！！
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) { // 不允许取关自己
            return;
        }
        Set<Integer> set = followMap.get(followerId);
        if (set != null) {
            set.remove(followeeId);
        }


    }
}

//带时间戳单链表
class Tweet {
    int id;
    int timestamp;
    Tweet next;

    Tweet(int id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }


    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        twitter.getNewsFeed(1);

        // 用户1关注了用户2.
        twitter.follow(1, 2);

        // 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

        // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
        // 推文id6应当在推文id5之前，因为它是在5之后发送的.
        twitter.getNewsFeed(1);

        // 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

        // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        // 因为用户1已经不再关注用户2.
        twitter.getNewsFeed(1);

    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */


