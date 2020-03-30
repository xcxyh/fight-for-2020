package com.xiong.JVMLearn;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/28 20:02
 * @description：
 * @modified By：
 * @version: $
 */
public class WeakHashMapDemo {

    public static void main(String[] args) {
        myHashMap();
        myWeakHashMap();
    }

    private static void myHashMap(){
        HashMap<Integer,String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "hashMap";
        map.put(key,value);

        key = null;
        System.out.println(map); //{1=hashMap}

        System.gc();
        System.out.println(map); //{1=hashMap}

    }

    private static void myWeakHashMap(){
        WeakHashMap<Integer,String> map = new WeakHashMap<>();
        Integer key = new Integer(2); // 不要自动装箱
        String value = "weakhashMap";
        map.put(key,value);

        key = null;
        System.out.println(map);  // {2=weakhashMap}

        System.gc();
        System.out.println(map); // {}

    }
}
