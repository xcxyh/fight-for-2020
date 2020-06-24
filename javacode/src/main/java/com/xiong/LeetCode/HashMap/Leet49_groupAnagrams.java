package com.xiong.LeetCode.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/6/15 9:51
 * @description： 49. 字母异位词分组  hashMap  key 的构造
 * @modified By：
 * @version: $
 */
public class Leet49_groupAnagrams {

    // 1 可以利用 hashMap的方法  即  key: 排序后的字符串 ，value: List(key的异构词)
    // 2 或者使用质数作为乘法因子 作为 key ，保证唯一
    // 3 或者初始化 key = "0#0#0#0#0#"，数字分别代表 abcde 出现的次数，# 用来分割。
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] bucket = new int[26];

            for(char c : str.toCharArray()){
                bucket[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            //构造key
            for(int x : bucket){
                sb.append(x);
                sb.append("#");
            }
            String key = sb.toString();
            if (!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }else{
                map.get(key).add(str);
            }
        }

        return new ArrayList<>(map.values());
    }


    // 利用质数 使用质数作为乘法因子 作为 key ，保证唯一。  作者：liweiwei1419
    public List<List<String>> groupAnagrams_liweiwei(String[] strs) {

        // 考察了哈希函数的基本知识，只要 26 个即可
        // （小写字母ACSII 码 - 97 ）以后和质数的对应规则，这个数组的元素顺序无所谓
        // key 是下标，value 就是数值
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};

        // key 是字符串自定义规则下的哈希值
        Map<Integer, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            int hashValue = 1;

            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                hashValue *= primes[c - 'a'];
            }

            // 把单词添加到哈希值相同的分组
            if (hashMap.containsKey(hashValue)) {
                List<String> curList = hashMap.get(hashValue);
                curList.add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);

                hashMap.put(hashValue, newList);
            }
        }
        return new ArrayList<>(hashMap.values());
    }

    //复杂度太高
    public List<List<String>> groupAnagrams_1(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        boolean[] added = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (added[i]) {
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            added[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (isEcceLetters(strs[i], strs[j])) {
                    list.add(strs[j]);
                    added[j] = true;
                }

            }
            ans.add(list);
        }
        return ans;
    }

    //判断两个字符串是否是 异构词
    private boolean isEcceLetters(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        int[] bucket = new int[26];

        for (char c : c1) {
            bucket[c - 'a']++;
        }
        for (char c : c2) {
            bucket[c - 'a']--;
        }
        for (int x : bucket) {
            if (x != 0) {
                return false;
            }
        }
        return true;
    }
}
