package com.xiong.AForkTheWork.ByteDance;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/7/8 19:49
 * @description：  list 删除
 * @modified By：
 * @version: $
 */
public class ListRemoveDemo {

   static class Item{
        int id;

        Item(int id){
            id = id;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        deletItem(list, 1);
    }

    private static void deletItem(List<Integer> list, int id ){

        // 会抛出 ConcurrentModificationException
        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            Integer value=it.next();
            if(value==id){
                list.remove(value);
            }
        }

    }

}
