package com.xiong.AForkTheWork.ByteDance;

import java.util.*;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/12 18:49
 * @description：  950. 按递增顺序显示卡牌  字节三面  面试题 0712
 * @modified By：
 * @version: $
 */
public class Leet950_deckRevealedIncreasing {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7})));
    }

    public  static int[] deckRevealedIncreasing(int[] deck) {


        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(deck);
        for (int i = 0; i < deck.length / 2; i++) {
            swap(deck, i, deck.length - i - 1);
        }

        for(int i = 0; i < deck.length; i++){

            if (!list.isEmpty()){
                int tail = list.removeLast();
                list.addFirst(tail);
            }
            list.addFirst(deck[i]);
        }

        int[] ans = new int[list.size()];

        for(int i= 0; i< list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;
    }


    private static void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;

    }


}
