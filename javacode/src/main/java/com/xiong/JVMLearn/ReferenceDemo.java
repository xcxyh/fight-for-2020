package com.xiong.JVMLearn;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author ：xiongcong
 * @date ：Created in 2020/3/28 19:35
 * @description：   强引用  不回收
 *                  软引用  堆内存不够了  就会回收
 *                  弱引用  只要 GC  就会回收
 *                  虚引用  任何时候都可能被回收  必须和引用对列（ReferenceQueue）联合使用
 *                  虚引用主要作用是跟踪对象被垃圾回收的状态
 * @modified By：
 * @version: $
 */
public class ReferenceDemo {

    private static void soft_Memory_enough(){

        Object o1 = new Object();

        SoftReference<Object> softReference = new SoftReference<>(o1);

        o1 = null;
        System.gc();// gc
        System.out.println(o1); // null
        System.out.println(softReference.get()); // 内存够用时不会回收 obj


        // 软引用的 应用   缓存 图片
        // 在内存不足时， jvm 会回收 这些软引用指向的对象  清除这些图片  避免 OOM
        Map<String,SoftReference<Object>> imageCache = new HashMap<>();

    }
    // 修改 vm 参数  -Xms10M -Xmx10M -XX:+PrintGCDetails
    private static void soft_Memory_notenough(){
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);

        System.out.println(o1); //
        System.out.println(softReference.get());
        o1 = null;

        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1); // null
            System.out.println(softReference.get());  // null
        }

    }

    private static void weak_reference_gc(){
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);

        System.out.println(o1);
        System.out.println(weakReference.get());
        o1 = null;
        System.gc();
        System.out.println("======================");
        System.out.println(o1); //null
        System.out.println(weakReference.get()); //null


        // 弱引用 的应用

        // 缓存中的   WeakHashMap

    }

    private static void phantom_reference(){
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o1);
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        //虚引用
        PhantomReference<Object> phantomReference = new PhantomReference<>(o1,referenceQueue);

        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("===================");
        o1 = null;
        System.gc();//gc
        try{ TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e){e.printStackTrace();}
        System.out.println(o1);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
    }


    public static void main(String[] args) {
        phantom_reference();
    }

}
