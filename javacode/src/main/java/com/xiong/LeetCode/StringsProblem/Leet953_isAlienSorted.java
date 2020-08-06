package com.xiong.LeetCode.StringsProblem;

import com.xiong.LeetCode.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/8/3 10:09
 * @description：
 * @modified By：
 * @version: $
 */
public class Leet953_isAlienSorted {

    public static void main(String[] args) {
        System.out.println(new Leet953_isAlienSorted().isAlienSorted(new String[]{"kuvp","q"}, "ngxlkthsjuoqcpavbfdermiywz"));
    }
    public boolean isAlienSorted_dalao(String[] words, String order) {
        //单词自己内部不排序
        //两单词之间只比较首字母，如果首字母相同，则比较下一个字母
        // char[] orderNum = new char[26];
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            map.put(order.charAt(i), i);
        }
        for(int i = 0; i < words.length - 1; i++){
            int len = Math.min(words[i].length(), words[i+1].length());
            int j = 0;
            for(j = 0; j < len; j++){
                if(map.get(words[i].charAt(j)) < map.get(words[i+1].charAt(j))){
                    break;
                }else if(map.get(words[i].charAt(j)) > map.get(words[i+1].charAt(j))){
                    //1字母的序列号在2字母的序列号后面，说明小的到了前面了
                    return false;
                }
            }
            if(j == len  && len == words[i + 1].length() && len != words[i].length()){
                //说明短的是后面那个单词
                return false;
            }
        }
        return true;
    }


    Map<Character, Character> orderMap;
    public boolean isAlienSorted(String[] words, String order) {
        orderMap = new HashMap<>();
        int k = 0;
        for(char c : order.toCharArray()){
            char newC = (char)('a' + k++);
            orderMap.put(c, newC);
        }
        // 0 对应 空
        // 把单词转化为数字字符串
        for(int i = 0 ; i< words.length; i++){
            words[i] = change(words[i]);
        }
        for(int i = 0 ; i< words.length - 1; i++){

            if (words[i].compareTo(words[i + 1]) > 0){
                return false;
            }
        }
        return true;
    }

    private String change(String word){
        int len = word.length();
        StringBuilder sb = new StringBuilder();
        for(char c : word.toCharArray()){
            sb.append(orderMap.get(c));
        }
        return sb.toString();
    }

}
