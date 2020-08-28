package com.xiong.LeetCode.TrieTreeOfString;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/12 17:25
 * @description： 用于字符串处理的前缀树
 * @modified By：
 * @version: $
 */
public class Trie {

    class TrieNode {
        // 链接到 它的子节点
        private TrieNode[] children;
        // 当前node 是否为 一个 单词的 末尾
        private boolean isEnd;
        // 26 个小写字母
        private final int R = 26;
        TrieNode() {
            children = new TrieNode[R];
        }
        private void put(char ch, TrieNode node) { children[ch - 'a'] = node; }
        private TrieNode get(char ch) { return children[ch - 'a']; }
        private boolean containsKey(char ch) { return children[ch - 'a'] != null; }
        private void setEnd() { isEnd = true; }
        private boolean isEnd() { return isEnd; }

    }

    // 以下为前缀树的 API

    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);

            if (!cur.containsKey(c)){
                cur.put(c, new TrieNode());
            }
            // 移动到这个新建的 node 上
            cur = cur.get(c);
        }
        //到达尾部
        cur.setEnd();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
}

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
        TrieNode cur = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            if (cur.containsKey(c)){
                //移动到下一个node
                cur = cur.get(c);
            }else{
                return null;
            }
        }
        return  cur;
    }



}
